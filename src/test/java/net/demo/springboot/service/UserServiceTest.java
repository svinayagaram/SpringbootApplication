package net.demo.springboot.service;

import net.demo.springboot.model.User;
import net.demo.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testPurchaseTicket() {
        // Mock data
        User user = new User("John", "Doe", "john.doe@example.com");
        String section = "Section A";

        // Mock userRepository.save()
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Call the method
        User savedUser = userService.purchaseTicket(user, section);

        // Verify the result
        assertEquals(user, savedUser);

        // Verify userRepository.save() is called with the correct argument
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testGetUserByEmail() {
        // Mock data
        String email = "john.doe@example.com";
        User user = new User("John", "Doe", email);

        // Mock userRepository.findByEmail()
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        // Call the method
        Optional<User> retrievedUser = userService.getUserByEmail(email);

        // Verify the result
        assertEquals(Optional.of(user), retrievedUser);

        // Verify userRepository.findByEmail() is called with the correct argument
        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    public void testGetUsersBySection() {
        // Mock data
        String section = "Section A";
        User user1 = new User("John", "Doe", "john.doe@example.com");
        User user2 = new User("Jane", "Smith", "jane.smith@example.com");
        List<User> userList = Arrays.asList(user1, user2);

        // Mock userRepository.findBySection()
        when(userRepository.findBySection(section)).thenReturn(userList);

        // Call the method
        List<User> retrievedUsers = userService.getUsersBySection(section);

        // Verify the result
        assertEquals(userList, retrievedUsers);

        // Verify userRepository.findBySection() is called with the correct argument
        verify(userRepository, times(1)).findBySection(section);
    }

    // Add similar test methods for removeUserByEmail and modifyUserSeat

}
