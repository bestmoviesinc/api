package com.bestmovies.bestmoviesinc.Repository;

import com.bestmovies.bestmoviesinc.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Find a user by username
    Optional<User> findByUsername(String username);

    // Find a user by username and password (for signing in)
    Optional<User> findByUsernameAndPassword(String username, String password);
}
