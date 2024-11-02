package usecase;


import curso.exception.ExceptionCurso;
import curso.modelo.Curso;
import curso.modelo.Level;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrarCursoTest {

    private UUID cursoId= UUID.randomUUID();
    @Mock
    private SaveBD bd;
    private RegistrarCurso registrarCurso;

    @BeforeEach
    public void setUp() {
        registrarCurso=new RegistrarCurso(bd);
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

    @Test
    public void RegistrarCurso_True(){
        Curso curso=Curso.factory(cursoId,"Programacion", LocalDate.MAX, Level.Avanzado);
        when(bd.buscarCursoName(curso.getName())).thenReturn(false);
        when(bd.saveCurso(any(Curso.class))).thenReturn(true);
        boolean result = registrarCurso.createCurso(curso.getName(), curso.getFecha_cierre_inscripcion(), curso.getNivel());
        Assertions.assertTrue(result);
    }

    @Test
    public void RegistrarCurso_Exite(){
        when(bd.buscarCursoName("programacion")).thenReturn(true);
        Assertions.assertThrows(ExceptionCurso.class, ()->registrarCurso.createCurso("programacion", LocalDate.MAX, Level.Avanzado));
    }

    @Test
    public void RegistrarCurso_Execption(){
        Assertions.assertThrows(ExceptionCurso.class, ()->registrarCurso.createCurso("", LocalDate.MAX, Level.Avanzado));
        Assertions.assertThrows(ExceptionCurso.class, ()->registrarCurso.createCurso("programacion", LocalDate.MAX, null));
        Assertions.assertThrows(ExceptionCurso.class, ()->registrarCurso.createCurso("programacion", null, Level.Avanzado));
        Assertions.assertThrows(ExceptionCurso.class, ()->registrarCurso.createCurso("programacion", LocalDate.MIN, Level.Avanzado));
    }
}
