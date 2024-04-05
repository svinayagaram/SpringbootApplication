

package net.demo.springboot.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseRequestTest {

    @Test
    public void testGetAndSetFrom() {
        // Create a PurchaseRequest object
        PurchaseRequest purchaseRequest = new PurchaseRequest();

        // Set the 'from' field
        purchaseRequest.setFrom("London");

        // Verify that the 'from' field is set correctly
        assertEquals("London", purchaseRequest.getFrom());
    }

    @Test
    public void testGetAndSetTo() {
        // Create a PurchaseRequest object
        PurchaseRequest purchaseRequest = new PurchaseRequest();

        // Set the 'to' field
        purchaseRequest.setTo("Paris");

        // Verify that the 'to' field is set correctly
        assertEquals("Paris", purchaseRequest.getTo());
    }

    @Test
    public void testGetAndSetUser() {
        // Create a User object
        User user = new User("John", "Doe", "john.doe@example.com");

        // Create a PurchaseRequest object
        PurchaseRequest purchaseRequest = new PurchaseRequest();

        // Set the 'user' field
        purchaseRequest.setUser(user);

        // Verify that the 'user' field is set correctly
        assertEquals(user, purchaseRequest.getUser());
    }

    @Test
    public void testGetAndSetPricePaid() {
        // Create a PurchaseRequest object
        PurchaseRequest purchaseRequest = new PurchaseRequest();

        // Set the 'pricePaid' field
        purchaseRequest.setPricePaid("$50");

        // Verify that the 'pricePaid' field is set correctly
        assertEquals("$50", purchaseRequest.getPricePaid());
    }
}

