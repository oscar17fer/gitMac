
package com.oscar.PacienteFeign.services;

import com.oscar.PacienteFeign.entity.Paciente;
import com.oscar.PacienteFeign.repository.IPacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServices implements IPacienteServices{
    
    @Autowired
    private IPacienteRepository pacienteRepo; 

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public void savePaciente(Paciente pac) {
        pacienteRepo.save(pac);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Paciente pac) {
        this.savePaciente(pac);
    }
    
}
