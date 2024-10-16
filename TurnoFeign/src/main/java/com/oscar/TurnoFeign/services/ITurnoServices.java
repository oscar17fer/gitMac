 
package com.oscar.TurnoFeign.services;

import com.oscar.TurnoFeign.DTO.TurnoDTO;
import com.oscar.TurnoFeign.entity.Turno;
import java.time.LocalDate;
import java.util.List;


public interface ITurnoServices {
    
    public List<Turno>getTurnos();
    
    public void saveTurno(TurnoDTO turno);
    
    public  void deleteTurno(Long id);
    
    public Turno findTurno(Long id);
    
    public void editTurno(Long id, Turno turno);
}
