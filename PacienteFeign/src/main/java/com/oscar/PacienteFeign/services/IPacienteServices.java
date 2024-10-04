
package com.oscar.PacienteFeign.services;

import com.oscar.PacienteFeign.entity.Paciente;
import java.util.List;


public interface IPacienteServices {
    
    public List<Paciente> getPacientes();
    
    public void savePaciente(Paciente pac);
    
    public void deletePaciente(Long id);
    
    public Paciente findPaciente(Long id);
    
    public void editPaciente(Paciente pac);
    
}
