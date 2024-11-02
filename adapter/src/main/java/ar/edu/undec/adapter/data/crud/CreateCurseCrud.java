package ar.edu.undec.adapter.data.crud;

import ar.edu.undec.adapter.data.entity.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreateCurseCrud extends CrudRepository<CursoEntity, UUID> {
    boolean existsByNome(String nome);
}
