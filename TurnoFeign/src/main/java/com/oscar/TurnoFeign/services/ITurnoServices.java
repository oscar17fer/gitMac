
package com.oscar.TurnoFeign.services;

import com.oscar.TurnoFeign.entity.Turno;
import java.time.LocalDate;
import java.util.List;


public interface ITurnoServices {
    
    public List<Turno>getTurnos();
    
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPAciente);
}
