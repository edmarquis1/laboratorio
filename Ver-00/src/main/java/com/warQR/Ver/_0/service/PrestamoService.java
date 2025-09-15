package com.warQR.Ver_0.service;

import com.warQR.Ver_0.model.Prestamo;
import com.warQR.Ver_0.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrestamoService {
    
    @Autowired
    private PrestamoRepository prestamoRepository;
    
    public List<Prestamo> listarTodos() {
        return prestamoRepository.findAll();
    }
    
    public List<Prestamo> listarActivos() {
        return prestamoRepository.findByActivo(true);
    }
    
    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }
    
    public Prestamo obtenerPorId(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }
    
    public void eliminar(Long id) {
        Prestamo prestamo = obtenerPorId(id);
        if (prestamo != null) {
            prestamo.setActivo(false);
            prestamoRepository.save(prestamo);
        }
    }
    
    public List<Object[]> obtenerEstadisticasElementos() {
        return prestamoRepository.countPrestamosPorElemento();
    }
    
    public List<Object[]> obtenerEstadisticasSolicitantes() {
        return prestamoRepository.countPrestamosPorSolicitante();
    }
}