package ar.edu.undec.adapter.data.repository;

import ar.edu.undec.adapter.data.crud.CreateCurseCrud;
import ar.edu.undec.adapter.data.mapper.Mapper;
import curso.modelo.Curso;
import curso.output.SaveBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RegistarCursoRepository implements SaveBD {

    private CreateCurseCrud curseCrud;
    @Autowired
    public RegistarCursoRepository(CreateCurseCrud curseCrud) {
        this.curseCrud = curseCrud;
    }

    @Override
    public boolean saveCurso(Curso curso) {
        try {
            curseCrud.save(Mapper.dataMapper(curso));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean buscarCursoName(String name) {
        return curseCrud.existeCurso(name);
    }
}
