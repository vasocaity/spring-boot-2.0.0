package todo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1")
    List<User> findByUsername(String username);
}