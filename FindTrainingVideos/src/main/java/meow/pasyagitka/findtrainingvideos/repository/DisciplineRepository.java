package meow.pasyagitka.findtrainingvideos.repository;

import meow.pasyagitka.findtrainingvideos.model.Discipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {
}

