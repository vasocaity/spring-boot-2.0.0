package todo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Integer> {

    List<Note> findByTask(String task);
}

