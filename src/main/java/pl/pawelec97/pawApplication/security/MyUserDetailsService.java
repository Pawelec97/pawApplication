package pl.pawelec97.pawApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pawelec97.pawApplication.model.DTO.UserAddDto;
import pl.pawelec97.pawApplication.model.User;
import pl.pawelec97.pawApplication.repositories.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+ username ));
        return user.map(MyUserDetails::new).get();
    }

    public void createUser(UserAddDto userDto) throws IllegalArgumentException{
        User user = new User();
        user.setUserName(userDto.getUsername());
        if(!userRepository.findAll(Example.of(user)).isEmpty()) {
            throw new IllegalArgumentException("User with this username already exist!");
        }
        String encodePassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encodePassword);
        user.setRoles("ROLE_USER");
        user.setActive(true);



        userRepository.save(user);
    }
}
