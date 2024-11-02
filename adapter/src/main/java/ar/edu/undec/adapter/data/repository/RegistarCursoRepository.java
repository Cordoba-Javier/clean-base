package ar.edu.undec.adapter.data.repository;

import ar.edu.undec.adapter.data.crud.CreateCurseCrud;
import ar.edu.undec.adapter.data.entity.CursoEntity;
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
            return curseCrud.save(Mapper.dataMapper(curso)).getId()!=null;

    }

    @Override
    public boolean buscarCursoId(UUID id) {
        return curseCrud.existeCurso(id);
    }
}
