package com.bestmovies.bestmoviesinc.Controller;

import com.bestmovies.bestmoviesinc.Entity.User;
import com.bestmovies.bestmoviesinc.Entity.UserFavoriteMovies;
import com.bestmovies.bestmoviesinc.Entity.UserFavoriteMoviesId;
import com.bestmovies.bestmoviesinc.Service.UserFavoriteMoviesService;
import com.bestmovies.bestmoviesinc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users/{userId}/favorites")
@CrossOrigin
public class UserFavoriteMoviesController {

    @Autowired
    private UserFavoriteMoviesService userFavoriteMoviesService;

    @Autowired
    private UserService userService;

    @PostMapping("/{movieId}")
    public ResponseEntity<UserFavoriteMovies> addFavoriteMovie(
            @PathVariable Integer userId,
            @PathVariable Integer movieId) {

        // Load the user from the database
        User user = userService.findUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Ensure the User object is set before creating UserFavoriteMovies
        if (user == null) {
            return ResponseEntity.badRequest().body(null); // or handle the error as needed
        }

        // Create the UserFavoriteMovies entity
        UserFavoriteMovies favoriteMovie = new UserFavoriteMovies(user, movieId);

        // Save the favorite movie
        UserFavoriteMovies savedFavorite = userFavoriteMoviesService.addFavoriteMovie(favoriteMovie);

        return ResponseEntity.ok(savedFavorite);
    }

    @GetMapping
    public ResponseEntity<List<UserFavoriteMovies>> getFavoriteMoviesByUserId(@PathVariable Integer userId) {
        List<UserFavoriteMovies> favoriteMovies = userFavoriteMoviesService.getFavoriteMoviesByUserId(userId);
        return ResponseEntity.ok(favoriteMovies);
    }


    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> removeFavoriteMovie(@PathVariable Integer userId, @PathVariable Integer movieId) {
        UserFavoriteMoviesId id = new UserFavoriteMoviesId(userId, movieId);
        userFavoriteMoviesService.removeFavoriteMovie(id);
        return ResponseEntity.noContent().build();
    }

}
