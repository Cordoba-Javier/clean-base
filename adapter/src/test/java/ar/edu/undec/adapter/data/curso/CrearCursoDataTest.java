package ar.edu.undec.adapter.data.curso;

import ar.edu.undec.adapter.data.crud.CreateCurseCrud;
import ar.edu.undec.adapter.data.entity.CursoEntity;
import ar.edu.undec.adapter.data.mapper.Mapper;
import ar.edu.undec.adapter.data.repository.RegistarCursoRepository;
import curso.modelo.Curso;
import curso.modelo.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoDataTest {
    @Mock
    CreateCurseCrud crud;

    @InjectMocks
    RegistarCursoRepository cursoRepository;


    @Test
    public void crearCurso_saveCrud() {
        Curso theCurso = Curso.factory(UUID.randomUUID(), "name", LocalDate.MAX, Level.Avanzado);
        when(crud.save(any(CursoEntity.class))).thenReturn(new CursoEntity());
        boolean result = cursoRepository.saveCurso(theCurso);
        Assertions.assertTrue(result);
    }

    //@Test
    //public void crearCurso_saveCrud() {
    //    Curso theCurso=Curso.factory(UUID.randomUUID(),"name", LocalDate.MAX, Level.Avanzado);
    //    when (crud.save(any(CursoEntity.class))).thenReturn(RuntimeException.class);
    //    boolean result= cursoRepository.saveCurso(theCurso);
    //    Assertions.assertTrue(result);
    //}
}