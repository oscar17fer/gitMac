
package com.oscar.TurnoFeign.repository;

import com.oscar.TurnoFeign.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long>{
    
}
