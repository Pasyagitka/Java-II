package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static meow.pasyagitka.findtrainingvideos.utils.Mapper.map;
import static meow.pasyagitka.findtrainingvideos.utils.Mapper.mapAll;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository repo;

    public UserDto save(UserDto user) {
        User v = repo.save(map(user, User.class));
        return map(v, UserDto.class);
    }

    public List<UserDto> listAll() {
        return mapAll((List<User>)repo.findAll(), UserDto.class);
    }

    public UserDto get(int id) {
        Optional<User> userOptional = repo.findById(id);
        return userOptional.map(user -> map(user, UserDto.class)).orElse(null);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
