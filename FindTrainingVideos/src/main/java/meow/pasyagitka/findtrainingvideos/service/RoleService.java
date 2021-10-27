package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.model.Role;
import meow.pasyagitka.findtrainingvideos.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository repo;

    public void save(Role role) {
        repo.save(role);
    }

    public List<Role> listAll() {
        return (List<Role>) repo.findAll();
    }

    public Role get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}