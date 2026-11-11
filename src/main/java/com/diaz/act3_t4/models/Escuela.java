package com.diaz.act3_t4.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "escuelas")
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    private String clave;

    // Relación OneToMany: Una escuela tiene muchos alumnos
    @OneToMany(mappedBy = "escuela", cascade = CascadeType.ALL)
    private List<Alumno> alumnos;

    public Escuela() {}

    public Escuela(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public List<Alumno> getAlumnos() { return alumnos; }
    public void setAlumnos(List<Alumno> alumnos) { this.alumnos = alumnos; }
}