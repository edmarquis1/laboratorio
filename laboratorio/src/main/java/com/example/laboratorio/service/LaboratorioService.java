package com.example.laboratorio.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioService {
    @Autowired
    private LaboratorioRepository laboratorioRepository;
    public List<Laboratorio> getAllLaboratorios() {
        return
                laboratorioRepository.findByEstadoNot(EstadoLaboratorio.ELIMINADO);
    }
    public Laboratorio createLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }
    public Laboratorio updateLaboratorio(Long id, Laboratorio laboratorioDetails)
    {
        Laboratorio laboratorio = laboratorioRepository.findById(id).orElseThrow();
        laboratorio.setNombre(laboratorioDetails.getNombre());
        laboratorio.setMateria(laboratorioDetails.getMateria());
        laboratorio.setCantidadEquipos(laboratorioDetails.getCantidadEquipos());
        return laboratorioRepository.save(laboratorio);
    }
    public Laboratorio updateEstadoLaboratorio(Long id, EstadoLaboratorio
            nuevoEstado) {
        Laboratorio laboratorio = laboratorioRepository.findById(id).orElseThrow();
        laboratorio.setEstado(nuevoEstado);
        return laboratorioRepository.save(laboratorio);
    }
    public void deleteLaboratorio(Long id) {
        updateEstadoLaboratorio(id, EstadoLaboratorio.ELIMINADO);
    }
}