package com.example.laboratorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/laboratorios")
public class LaboratorioController {
    @Autowired
    private LaboratorioService laboratorioService;
    // API REST
    @GetMapping("/api")
    public @ResponseBody List<Laboratorio> getAllLaboratoriosApi() {
        return laboratorioService.getAllLaboratorios();
    }
    @PostMapping("/api")
    public @ResponseBody Laboratorio createLaboratorioApi(@RequestBody
                                                          Laboratorio laboratorio) {
        return laboratorioService.createLaboratorio(laboratorio);
    }
    @PutMapping("/api/{id}")
    public @ResponseBody Laboratorio updateLaboratorioApi(@PathVariable Long
                                                                  id, @RequestBody Laboratorio laboratorio) {
        return laboratorioService.updateLaboratorio(id, laboratorio);
    }
    @PatchMapping("/api/{id}/estado")
    public @ResponseBody Laboratorio updateEstadoApi(@PathVariable Long id,
                                                     @RequestParam EstadoLaboratorio estado) {
        return laboratorioService.updateEstadoLaboratorio(id, estado);
    }
    @DeleteMapping("/api/{id}")
    public @ResponseBody void deleteLaboratorioApi(@PathVariable Long id) {
        laboratorioService.deleteLaboratorio(id);
    }
    // Vistas HTML
    @GetMapping
    public String getAllLaboratorios(Model model) {
        model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
        model.addAttribute("nuevoLaboratorio", new Laboratorio());
        return "laboratorios";
    }
    @PostMapping
    public String createLaboratorio(@ModelAttribute Laboratorio laboratorio) {
        laboratorioService.createLaboratorio(laboratorio);
        return "redirect:/laboratorios";
    }
    @PostMapping("/{id}/eliminar")
    public String deleteLaboratorio(@PathVariable Long id) {
        laboratorioService.deleteLaboratorio(id);
        return "redirect:/laboratorios";
    }
    @PostMapping("/{id}/estado")
    public String updateEstado(@PathVariable Long id, @RequestParam
    EstadoLaboratorio estado) {
        laboratorioService.updateEstadoLaboratorio(id, estado);
        return "redirect:/laboratorios";
    }
}