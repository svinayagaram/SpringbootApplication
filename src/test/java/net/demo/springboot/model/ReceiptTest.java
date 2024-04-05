package net.demo.springboot.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {

    @Test
    public void testConstructorAndGetters() {
        // Create a User object
        User user = new User("John", "Doe", "john.doe@example.com");

        // Create a Receipt object
        Receipt receipt = new Receipt("London", "Paris", user, "$50");

        // Verify the fields set by the constructor
        assertEquals("London", receipt.getFrom());
        assertEquals("Paris", receipt.getTo());
        assertEquals(user, receipt.getUser());
        assertEquals("$50", receipt.getPricePaid());
    }

    @Test
    public void testSetters() {
        // Create a User object
        User user = new User("John", "Doe", "john.doe@example.com");

        // Create a Receipt object
        Receipt receipt = new Receipt(null, null, null, null);

        // Set the fields using setter methods
        receipt.setFrom("London");
        receipt.setTo("Paris");
        receipt.setUser(user);
        receipt.setPricePaid("$50");

        // Verify the fields set by the setter methods
        assertEquals("London", receipt.getFrom());
        assertEquals("Paris", receipt.getTo());
        assertEquals(user, receipt.getUser());
        assertEquals("$50", receipt.getPricePaid());
    }
}
