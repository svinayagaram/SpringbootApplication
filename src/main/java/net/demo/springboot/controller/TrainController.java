package net.demo.springboot.controller;

import net.demo.springboot.model.PurchaseRequest;
import net.demo.springboot.model.Receipt;
import net.demo.springboot.model.User;
import net.demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TrainController {

    @Autowired
    private UserService userService;

    @PostMapping("/purchase_ticket")
    public ResponseEntity<Receipt> purchaseTicket(@RequestBody PurchaseRequest purchaseRequest) {
        // Extracting data from the purchase request
        String from = purchaseRequest.getFrom();
        String to = purchaseRequest.getTo();
        String firstName = purchaseRequest.getUser().getFirstName();
        String lastName = purchaseRequest.getUser().getLastName();
        String email = purchaseRequest.getUser().getEmail();
        String section = purchaseRequest.getUser().getSection();
        String pricePaid = purchaseRequest.getPricePaid();

        // Create the user object
        User user = new User(firstName,lastName,email,section,pricePaid);
        // Purchase the ticket
        User purchasedUser = userService.purchaseTicket(user,section);

        // Create the receipt object
        Receipt receipt = new Receipt(from, to, purchasedUser, pricePaid);

        // Return the receipt in the response
        return new ResponseEntity<>(receipt, HttpStatus.OK);
    }



    @GetMapping("/receipt/{email}")
    public ResponseEntity<Receipt> getReceipt(@PathVariable String email) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Receipt receipt = new Receipt("London", "Paris", user, "$50"); // Assuming fixed receipt details
            return ResponseEntity.ok(receipt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<User> purchaseTicket(@RequestBody User user, @RequestParam String section) {
        User savedUser = userService.purchaseTicket(user, section);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/users/section/{section}")
    public ResponseEntity<List<User>> getUsersBySection(@PathVariable String section) {
        List<User> users = userService.getUsersBySection(section);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<Void> removeUserByEmail(@PathVariable String email) {
        userService.removeUserByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{email}/section")
    public ResponseEntity<User> modifyUserSeat(@PathVariable String email, @RequestParam String section) {
        Optional<User> userOptional = userService.modifyUserSeat(email, section);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
