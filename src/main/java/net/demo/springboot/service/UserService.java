package net.demo.springboot.service;

import net.demo.springboot.model.User;
import net.demo.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User purchaseTicket(User user,String section) {
        user.setSection(section);
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> getUsersBySection(String section) {
        return userRepository.findBySection(section);
    }

    public void removeUserByEmail(String email) {
        userRepository.findByEmail(email).ifPresent(userRepository::delete);
    }

    public Optional<User> modifyUserSeat(String email, String section) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setSection(section);
            userRepository.save(user);
        }
        return userOptional;
    }
}
