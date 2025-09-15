package com.warQR.Ver_0.repository;

import com.warQR.Ver_0.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    
    List<Prestamo> findByActivo(boolean activo);
    
    @Query("SELECT p.elementoPrestado, COUNT(p) FROM Prestamo p WHERE p.activo = true GROUP BY p.elementoPrestado")
    List<Object[]> countPrestamosPorElemento();
    
    @Query("SELECT p.solicitante, COUNT(p) FROM Prestamo p WHERE p.activo = true GROUP BY p.solicitante")
    List<Object[]> countPrestamosPorSolicitante();
}