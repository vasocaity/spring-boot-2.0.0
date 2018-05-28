package todo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Integer> {

    List<Note> findByTask(String task);

    @Query(value = "SELECT * FROM note WHERE user_id = ?1",nativeQuery = true)
    List<Note> findByUserId(Integer username);
}

