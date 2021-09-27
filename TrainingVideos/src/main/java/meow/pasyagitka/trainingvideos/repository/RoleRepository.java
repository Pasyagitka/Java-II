package meow.pasyagitka.trainingvideos.repository;

import meow.pasyagitka.trainingvideos.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    Role findById(int id);
    //Role findByName(String name);
}