package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.model.Role;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.repository.RoleRepository;
import meow.pasyagitka.findtrainingvideos.repository.UserRepository;
import meow.pasyagitka.findtrainingvideos.dto.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static meow.pasyagitka.findtrainingvideos.utils.Mapper.map;
import static meow.pasyagitka.findtrainingvideos.utils.Mapper.mapAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Transactional
public class UserService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User saveUser(User userEntity) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }


    public List<UserDto> listAll() {
        return mapAll((List<User>) userRepository.findAll(), UserDto.class);
    }

    public UserDto get(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(user -> map(user, UserDto.class)).orElse(null);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public UserDto findByLogin(String login) {
        for (User user : userRepository.findAll()) {
            if (user.getLogin().equals(login)) {
                return map(user, UserDto.class);
            }
        } return null;
    }

    public UserDto findByLoginAndPassword(String login, String password) {
        UserDto userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userEntity = this.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
