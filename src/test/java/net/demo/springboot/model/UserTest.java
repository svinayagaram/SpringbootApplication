package net.demo.springboot.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        // Create a User object
        User user = new User(1L, "John", "Doe", "john.doe@example.com", "Section A", "$50");

        // Verify the fields set by the constructor
        assertEquals(1L, user.getId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("Section A", user.getSection());
        assertEquals("$50", user.getPricePaid());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a User object
        User user = new User();

        // Set the fields using setter methods
        user.setId(1L);
        user.setFirstName("Jane");
        user.setLastName("Smith");
        user.setEmail("jane.smith@example.com");
        user.setSection("Section B");
        user.setPricePaid("$100");

        assertEquals(1L, user.getId());
        assertEquals("Jane", user.getFirstName());
        assertEquals("Smith", user.getLastName());
        assertEquals("jane.smith@example.com", user.getEmail());
        assertEquals("Section B", user.getSection());
        assertEquals("$100", user.getPricePaid());
    }


}
