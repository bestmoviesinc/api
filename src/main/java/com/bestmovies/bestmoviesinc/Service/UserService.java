package com.bestmovies.bestmoviesinc.Service;

import com.bestmovies.bestmoviesinc.Entity.User;
import com.bestmovies.bestmoviesinc.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken.");
        }
        return userRepository.save(user);
    }

    public Optional<User> signIn(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User editUserDetails(Integer userId, User updatedUserDetails) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            // Only allow updates to fields other than username and password
            if (updatedUserDetails.getFirstName() != null) {
                user.setFirstName(updatedUserDetails.getFirstName());
            }
            if (updatedUserDetails.getLastName() != null) {
                user.setLastName(updatedUserDetails.getLastName());
            }
            if (updatedUserDetails.getAge() != null) {
                user.setAge(updatedUserDetails.getAge());
            }
            if (updatedUserDetails.getProfession() != null) {
                user.setProfession(updatedUserDetails.getProfession());
            }

            // Save the updated user back to the repository
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found.");
        }
    }


    // Find user by ID
    public Optional<User> findUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    // Delete user by ID
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

}
