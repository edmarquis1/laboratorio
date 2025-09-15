package com.warQR.Ver_0.model;  // ⚠️ Importante: Ver_0 con _

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String solicitante;
    private String elementoPrestado;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean activo = true;

    // Constructores
    public Prestamo() {
    }

    public Prestamo(String solicitante, String elementoPrestado, Date fechaPrestamo, Date fechaDevolucion) {
        this.solicitante = solicitante;
        this.elementoPrestado = elementoPrestado;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }
    
    public String getElementoPrestado() { return elementoPrestado; }
    public void setElementoPrestado(String elementoPrestado) { this.elementoPrestado = elementoPrestado; }
    
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    
    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}