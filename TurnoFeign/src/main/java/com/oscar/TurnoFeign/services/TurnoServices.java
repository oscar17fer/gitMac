
package com.oscar.TurnoFeign.services;

import com.oscar.TurnoFeign.DTO.TurnoDTO;
import com.oscar.TurnoFeign.entity.Turno;
import com.oscar.TurnoFeign.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServices implements ITurnoServices {
    
    @Autowired
    private ITurnoRepository turnoRepo;

    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public void saveTurno(TurnoDTO turno) {
        //buscar el paciente en la api pacientes test
        //Paciente pac= buscar en la appi
        //String nombre completo =lo que consumo de l nombre de la api
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno tur = this.findTurno(id);
        tur.setFecha(turno.getFecha());
        tur.setTratamiento(turno.getTratamiento());
        tur.setNombreCompleto(turno.getNombreCompleto());
        
        turnoRepo.save(tur);
    }
    
    
}
