package net.demo.springboot.controller;

import net.demo.springboot.model.PurchaseRequest;
import net.demo.springboot.model.Receipt;
import net.demo.springboot.model.User;
import net.demo.springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class TrainControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private TrainController trainController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPurchaseTicket() {
        // Mock PurchaseRequest
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setFrom("London");
        purchaseRequest.setTo("Paris");
        User user = new User("John", "Doe", "john.doe@example.com");
        purchaseRequest.setUser(user);
        purchaseRequest.setPricePaid("$50");

        // Mock userService.purchaseTicket()
        when(userService.purchaseTicket(any(User.class), anyString())).thenReturn(user);

        // Call the controller method
        ResponseEntity<Receipt> responseEntity = trainController.purchaseTicket(purchaseRequest);

        // Verify the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("London", responseEntity.getBody().getFrom());
        assertEquals("Paris", responseEntity.getBody().getTo());
        assertEquals("John", responseEntity.getBody().getUser().getFirstName());
        assertEquals("Doe", responseEntity.getBody().getUser().getLastName());
        assertEquals("john.doe@example.com", responseEntity.getBody().getUser().getEmail());
        assertEquals("$50", responseEntity.getBody().getPricePaid());

        // Verify userService.purchaseTicket() is called
        verify(userService, times(1)).purchaseTicket(any(User.class), anyString());
    }



}
