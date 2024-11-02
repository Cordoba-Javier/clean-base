package curso.input;

import curso.exception.ExceptionCurso;
import curso.modelo.Level;

import java.time.LocalDate;
import java.util.UUID;

public interface CreateCurse {
    public boolean createCurso(String name, LocalDate fecha_cierre_inscripcion, Level nivel)throws ExceptionCurso;
}
