package com.example.laboratorio.model;

@Entity
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String materia;
    private int cantidadEquipos;
    @Enumerated(EnumType.STRING)
    private EstadoLaboratorio estado;
    // Constructor, getters y setters
    public Laboratorio() {}
    public Laboratorio(String nombre, String materia, int cantidadEquipos) {
        this.nombre = nombre;
        this.materia = materia;
        this.cantidadEquipos = cantidadEquipos;
        this.estado = EstadoLaboratorio.DISPONIBLE;
    }
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }
    public int getCantidadEquipos() { return cantidadEquipos; }
    public void setCantidadEquipos(int cantidadEquipos) { this.cantidadEquipos =
            cantidadEquipos; }
    public EstadoLaboratorio getEstado() { return estado; }
    public void setEstado(EstadoLaboratorio estado) { this.estado = estado; }
}
enum EstadoLaboratorio {
    DISPONIBLE,
    PRESTADO,
    ELIMINADO
}
