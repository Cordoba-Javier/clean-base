package curso.usecase;

import curso.input.CreaterCurse;
import curso.modelo.Curso;
import curso.modelo.Level;
import curso.output.Consulta;
import curso.output.SaveBD;

import java.time.LocalDate;

public class RegistrarCurso implements CreaterCurse {
    private final Consulta consulta;
    private final SaveBD bd;
    public RegistrarCurso(Consulta consulta, SaveBD bd) {
        this.consulta = consulta;
        this.bd = bd;
    }

    @Override
    public boolean createCurso(String id, String nombre, LocalDate fecha_cierre_inscripcion, Level nivel) {
        Curso c=Curso.factory(id, nombre, fecha_cierre_inscripcion, nivel);
        if(consulta.buscarCursoId(c.getId()))
            return false;
        return bd.save(c);
    }
}
