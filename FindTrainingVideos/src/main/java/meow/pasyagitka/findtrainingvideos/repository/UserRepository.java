package meow.pasyagitka.findtrainingvideos.repository;

import meow.pasyagitka.findtrainingvideos.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
