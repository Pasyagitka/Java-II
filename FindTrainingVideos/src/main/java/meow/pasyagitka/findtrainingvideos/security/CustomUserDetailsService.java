package meow.pasyagitka.findtrainingvideos.security;

import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    //достать из базы данных моего юзера по логину, конвертирую его в CustomUser и возвращаю:
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userEntity = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
