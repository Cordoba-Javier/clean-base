package usecase;


import curso.exception.ExceptionCurso;
import curso.modelo.Curso;
import curso.modelo.Level;
import curso.output.Consulta;
import curso.output.SaveBD;
import curso.usecase.RegistrarCurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrarCursoTest {

    private UUID cursoId= UUID.randomUUID();
    @Mock
    private Consulta consu;
    private SaveBD bd;
    private RegistrarCurso registrarCurso;

    @BeforeEach
    public void setUp() {
        registrarCurso=new RegistrarCurso(consu, bd);
    }

    @Test
    public void factoryCurso() {
        Curso c = Curso.factory(cursoId,"Programacion", LocalDate.of(2024,12,20), Level.Avanzado);
        Assertions.assertNotNull(c);
    }

    @Test
    public void factoryCurso_fail() {

        Assertions.assertThrows(ExceptionCurso.class, () ->Curso.factory(cursoId,"", LocalDate.of(2024,12,20), Level.Avanzado));
        Assertions.assertThrows(ExceptionCurso.class, () ->Curso.factory(cursoId,"Programacion", LocalDate.of(2023,12,20), Level.Avanzado));
        Assertions.assertThrows(ExceptionCurso.class, () ->Curso.factory(cursoId,"Programacion", null, Level.Avanzado));
        Assertions.assertThrows(ExceptionCurso.class, () ->Curso.factory(cursoId,"Programacion", LocalDate.of(2025,1,3), null));
    }

}
