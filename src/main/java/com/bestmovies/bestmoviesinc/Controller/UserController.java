package com.bestmovies.bestmoviesinc.Controller;


import com.bestmovies.bestmoviesinc.Entity.User;
import com.bestmovies.bestmoviesinc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        Optional<User> userOptional = userService.signIn(username, password);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserDetails(@PathVariable Integer id, @RequestBody User userDetails) {
        User updatedUser = userService.editUserDetails(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> userOptional = userService.findUserById(id);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
