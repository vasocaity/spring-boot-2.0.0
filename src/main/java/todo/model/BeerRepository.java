package todo.model;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import todo.model.Beer;


interface BeerRepository extends JpaRepository<Beer, Long> {
}