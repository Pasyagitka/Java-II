package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.dto.RoleDto;
import meow.pasyagitka.findtrainingvideos.model.Role;
import meow.pasyagitka.findtrainingvideos.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static meow.pasyagitka.findtrainingvideos.utils.Mapper.map;
import static meow.pasyagitka.findtrainingvideos.utils.Mapper.mapAll;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository repo;

    public RoleDto get(int id) {
        Optional<Role> roleOptional = repo.findById(id);
        return roleOptional.map(role -> map(role, RoleDto.class)).orElse(null);
    }
}