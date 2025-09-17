package com.example.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface LaboratorioRepository extends JpaRepository<Laboratorio,
        Long> {
    List<Laboratorio> findByEstadoNot(EstadoLaboratorio estado);
}
