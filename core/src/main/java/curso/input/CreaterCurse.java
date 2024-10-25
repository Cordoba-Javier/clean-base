package curso.input;

import curso.modelo.Level;

import java.time.LocalDate;

public interface CreaterCurse {
    boolean createCurso(String id, String nombre, LocalDate fecha_cierre_inscripcion, Level nivel);
}
