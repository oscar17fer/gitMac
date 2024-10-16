
package com.oscar.TurnoFeign.repository;

import com.oscar.TurnoFeign.DTO.TurnoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacienteApi", url = "http://localhost:9001/pacientes")
public interface PacienteAPIClient {
    
    @GetMapping("/paciente/{dniPaciente}")
    public TurnoDTO getPacienteInfo(@PathVariable("dniPaciente")String dniPaciente );
}
