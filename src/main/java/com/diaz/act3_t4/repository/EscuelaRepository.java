package com.diaz.act3_t4.repository;

import com.diaz.act3_t4.models.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Integer> {
    // Hereda todos los métodos CRUD para la entidad Escuela (save, findAll, findById, deleteById, etc.)
}