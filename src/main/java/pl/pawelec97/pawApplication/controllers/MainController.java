package pl.pawelec97.pawApplication.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawelec97.pawApplication.model.User;
import pl.pawelec97.pawApplication.repositories.UserRepository;

@RestController

public class MainController {


    UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

//    @GetMapping("/user")
//    public String user(){
//        return "test auth";
//    }

}
