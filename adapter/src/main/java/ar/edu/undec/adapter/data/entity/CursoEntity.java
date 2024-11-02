package ar.edu.undec.adapter.data.entity;

import curso.modelo.Curso;
import curso.modelo.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;
@Entity(name="curso")
public class CursoEntity {
    @Id
    private UUID id;
    @Column(name="nombre")
    private String name;
    @Column(name="fecha_inscripcion")
    private LocalDate fecha_cierre_inscripcion;
    @Column(name="nivel")
    private Level nivel;

    public CursoEntity() {}

    public CursoEntity(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level nivel) {
        this.id = id;
        this.name = name;
        this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
        this.nivel = nivel;
    }

    public static CursoEntity crearEntity(Curso curso) {
        return new CursoEntity(curso.getId(),curso.getName(),curso.getFecha_cierre_inscripcion(),curso.getNivel());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFecha_cierre_inscripcion() {
        return fecha_cierre_inscripcion;
    }

    public Level getNivel() {
        return nivel;
    }
}
