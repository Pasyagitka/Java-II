package meow.pasyagitka.trainingvideos.service;

import meow.pasyagitka.trainingvideos.model.Role;
import meow.pasyagitka.trainingvideos.model.User;
import meow.pasyagitka.trainingvideos.repository.RoleRepository;
import meow.pasyagitka.trainingvideos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userEntityRepository;
    @Autowired
    private RoleRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User userEntity) {
        Role userRole = roleEntityRepository.findByName("ROLE_USER");
        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public User findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        User userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
