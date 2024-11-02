package curso.usecase;

import curso.exception.ExceptionCurso;
import curso.input.CreateCurse;
import curso.modelo.Curso;
import curso.modelo.Level;
import curso.output.SaveBD;

import java.time.LocalDate;
import java.util.UUID;

public class RegistrarCurso implements CreateCurse {
    private SaveBD bd;

    public RegistrarCurso(SaveBD bd) {
        this.bd = bd;
    }

    @Override
    public boolean createCurso(String name, LocalDate fecha_cierre_inscripcion, Level nivel)throws ExceptionCurso {
        Curso c=Curso.factory(UUID.randomUUID(), name, fecha_cierre_inscripcion, nivel);
        if(bd.buscarCursoName(c.getName()))
            throw new ExceptionCurso("El curso ya existe");
        return bd.saveCurso(c);
    }
}
