package curso.output;

import curso.modelo.Curso;

import java.util.UUID;

public interface SaveBD {
    boolean saveCurso(Curso curso);
    boolean buscarCursoId(UUID id);
}
