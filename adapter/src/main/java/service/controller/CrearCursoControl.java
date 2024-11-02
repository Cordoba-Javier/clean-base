package service.controller;

import curso.input.CreaterCurse;
import curso.modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.dto.CursoDTO;

@RestController
@RequestMapping("curso")
public class CrearCursoControl {
    private CreaterCurse createrCurse;

    @Autowired
    public CrearCursoControl(CreaterCurse createrCurse) {
        this.createrCurse = createrCurse;
    }

    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody CursoDTO curso) {
        if(createrCurse.createCurso(curso.getId(),curso.getName(),curso.getFecha_cierre_inscripcion(),curso.getNivel())){
            return ResponseEntity.ok().build();
        }else{
        return ResponseEntity.badRequest().body("No pudo crear curso");}
    }
}
