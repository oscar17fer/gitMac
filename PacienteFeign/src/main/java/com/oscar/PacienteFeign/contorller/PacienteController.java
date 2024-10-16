
package com.oscar.PacienteFeign.contorller;

import com.oscar.PacienteFeign.entity.Paciente;
import com.oscar.PacienteFeign.services.IPacienteServices;
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
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private IPacienteServices pacienteServ;
    
    //1 crear un nuevo paciente
    @PostMapping ("/crear")
    private String crearPaciente(@RequestBody Paciente pac){
        pacienteServ.savePaciente(pac);
        return "paciente creado exitosamente";
    }
    
    //2 obtener todos los pacientes
    @GetMapping ("/traer")
    private List<Paciente> trearPacientes(){
        return pacienteServ.getPacientes();
    }
    
    //3 eliminar un paciente
    @DeleteMapping("/borrar/{id}")
    private String deletePaciente(@PathVariable Long id){
        pacienteServ.deletePaciente(id);
        return "paciente eliminado exitosamente";
    }
    
    //4 editar Paciente
    @PutMapping("/editar/{id_original}")
    private Paciente editPaciente(@PathVariable Long id_original,
                                  @RequestBody Paciente pac){
        pacienteServ.editPaciente(pac, id_original);
        Paciente pacienteEditado = pacienteServ.findPaciente(id_original);
        
        return pacienteEditado;
    }
    
    //5 obtener un paciente en particular
    @GetMapping("/traer/{id}")
    public Paciente traerPaciente(@PathVariable Long id){
        return pacienteServ.findPaciente(id);
    }
    
    
    @GetMapping("/traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }
    
}
