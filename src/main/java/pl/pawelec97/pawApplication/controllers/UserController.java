package pl.pawelec97.pawApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pawelec97.pawApplication.model.DTO.UserAddDto;
import pl.pawelec97.pawApplication.model.User;
import pl.pawelec97.pawApplication.repositories.UserRepository;
import pl.pawelec97.pawApplication.security.MyUserDetailsService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserRepository userRepository;
    private MyUserDetailsService myUserDetailsService;

    public UserController(UserRepository userRepository, MyUserDetailsService myUserDetailsService) {
        this.userRepository = userRepository;
        this.myUserDetailsService = myUserDetailsService;
    }
    @GetMapping("/list")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserAddDto appUser) {
        myUserDetailsService.createUser(appUser);
        return "register succesfull!";
    }
}
