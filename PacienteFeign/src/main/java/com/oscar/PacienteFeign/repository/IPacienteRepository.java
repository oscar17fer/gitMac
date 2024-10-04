
package com.oscar.PacienteFeign.repository;

import com.oscar.PacienteFeign.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long>{
    
}
