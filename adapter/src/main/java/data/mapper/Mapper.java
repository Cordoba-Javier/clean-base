package data.mapper;

import curso.modelo.Curso;
import data.entity.CursoEntity;

public class Mapper {
    public static Curso coreMapper(CursoEntity cursoEntity) {
        return Curso.factory(cursoEntity.getId(),cursoEntity.getName(),cursoEntity.getFecha_cierre_inscripcion(),cursoEntity.getNivel());
    }
    public static CursoEntity dataMapper(Curso curso) {
        return CursoEntity.crearEntity(curso);
    }
}
