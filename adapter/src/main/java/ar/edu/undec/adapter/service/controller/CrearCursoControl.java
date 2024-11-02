package ar.edu.undec.adapter.service.controller;

import curso.input.CreateCurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.undec.adapter.service.dto.CursoDTO;

import java.net.URI;

@RestController
@RequestMapping("curso")
public class CrearCursoControl {
    private CreateCurse createrCurse;

    @Autowired
    public CrearCursoControl(CreateCurse createrCurse) {
        this.createrCurse = createrCurse;
    }

    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody CursoDTO curso) {
        try {
            createrCurse.createCurso(curso.getName(),curso.getFecha_cierre_inscripcion(),curso.getNivel());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No pudo crear curso");
        }

    }
}
