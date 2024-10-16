
package com.oscar.TurnoFeign.controller;

import com.oscar.TurnoFeign.DTO.TurnoDTO;
import com.oscar.TurnoFeign.entity.Turno;
import com.oscar.TurnoFeign.services.TurnoServices;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    
    @Autowired
    private TurnoServices turnoServ;
    
    // 1 crearun nuevo turno 
    @PostMapping("/crear")
    public String crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoServ.saveTurno(turnoDTO.getFecha(), turnoDTO.getTratamiento(), turnoDTO.getDniPaciente());
        
        return "turno creado correctamente";
    }
     
    // 2 obtener un turno 
    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return turnoServ.getTurnos();
        
    }
    
    // 3 Eliminar Turno 
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);
        return "turno eliminado";
    }
    
    // 4 edit turno
    @PutMapping("/editar/{id_original}")
    public Turno editTurno(@PathVariable Long id_original,
                           @RequestBody Turno turnoEditar ){
        turnoServ.editTurno(id_original, turnoEditar);
        Turno turnoEditado = turnoServ.findTurno(id_original);
        
        return turnoEditado;
    }
    
    // 5 obtener un turno en particular
    @GetMapping("/traer/{id}")
    public Turno traerTurno (@PathVariable Long id){
        return turnoServ.findTurno(id);
    }
}
