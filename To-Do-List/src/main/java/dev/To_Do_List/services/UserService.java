package dev.To_Do_List.services;

import dev.To_Do_List.models.User;
import dev.To_Do_List.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public void sign_up(String name, String email, String password)
    {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
        {
            System.out.println("User already exists!");
            return;
        }
        String new_password = bCryptPasswordEncoder.encode(password);
        User new_user = new User(name, email, new_password);
        userRepository.save(new_user);
        System.out.println("Registration successful!");
    }
    public boolean sign_in(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
        {
            if(bCryptPasswordEncoder.matches(password, user.get().getPassword()))
                return true;
        }
        System.out.println("Incorrect email or password!");
        return false;
    }
}
