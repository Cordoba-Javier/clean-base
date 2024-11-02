package curso.usecase;

import curso.exception.ExceptionCurso;
import curso.input.CreaterCurse;
import curso.modelo.Curso;
import curso.modelo.Level;
import curso.output.Consulta;
import curso.output.SaveBD;

import java.time.LocalDate;
import java.util.UUID;

public class RegistrarCurso implements CreaterCurse {
    private Consulta consulta;
    private SaveBD bd;

    public RegistrarCurso(Consulta consulta, SaveBD bd) {
        this.consulta = consulta;
        this.bd = bd;
    }

    @Override
    public boolean createCurso(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level nivel)throws ExceptionCurso {
        Curso c=Curso.factory(id, name, fecha_cierre_inscripcion, nivel);
        if(consulta.buscarCursoName(c.getId()))
            throw new ExceptionCurso("El curso ya existe");
        return bd.save(c);
    }
}
