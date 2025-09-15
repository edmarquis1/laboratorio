package com.warQR.Ver_0.controller;

import com.warQR.Ver_0.model.Prestamo;
import com.warQR.Ver_0.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {
    
    @Autowired
    private PrestamoService prestamoService;
    
    @GetMapping
    public String listarPrestamos(Model model) {
        model.addAttribute("prestamos", prestamoService.listarActivos());
        return "index";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        return "agregar";
    }
    
    @PostMapping("/guardar")
    public String guardarPrestamo(@ModelAttribute Prestamo prestamo) {
        prestamo.setFechaPrestamo(new Date());
        prestamoService.guardar(prestamo);
        return "redirect:/prestamos";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("prestamo", prestamoService.obtenerPorId(id));
        return "editar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminar(id);
        return "redirect:/prestamos";
    }
    
    @GetMapping("/estadisticas")
    public String mostrarEstadisticas(Model model) {
        model.addAttribute("estadisticasElementos", 
            prestamoService.obtenerEstadisticasElementos());
        model.addAttribute("estadisticasSolicitantes", 
            prestamoService.obtenerEstadisticasSolicitantes());
        return "estadisticas";
    }
}