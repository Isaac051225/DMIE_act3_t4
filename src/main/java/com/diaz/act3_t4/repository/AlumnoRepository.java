package com.diaz.act3_t4.repository;

import com.diaz.act3_t4.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    // Hereda todos los métodos CRUD para la entidad Alumno
}
