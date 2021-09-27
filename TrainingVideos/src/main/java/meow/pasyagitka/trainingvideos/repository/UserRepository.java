package meow.pasyagitka.trainingvideos.repository;

import meow.pasyagitka.trainingvideos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
