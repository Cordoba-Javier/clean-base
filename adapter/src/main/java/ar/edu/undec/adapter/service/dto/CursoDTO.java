package ar.edu.undec.adapter.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import curso.modelo.Level;

import java.time.LocalDate;
import java.util.UUID;

public class CursoDTO {
    @JsonProperty("id")
    private final UUID id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("fecha_cierre_inscripcion")
    private  final LocalDate fecha_cierre_inscripcion;
    @JsonProperty("nivel")
    private Level nivel;

    private CursoDTO(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level nivel) {
        this.id = id;
        this.name = name;
        this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
        this.nivel = nivel;
    }

    public static CursoDTO factoryDTO(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level nivel){
        return new CursoDTO(id, name, fecha_cierre_inscripcion, nivel);
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
