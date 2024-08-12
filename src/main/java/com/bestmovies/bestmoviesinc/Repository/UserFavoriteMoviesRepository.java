package com.bestmovies.bestmoviesinc.Repository;
import com.bestmovies.bestmoviesinc.Entity.UserFavoriteMovies;
import com.bestmovies.bestmoviesinc.Entity.UserFavoriteMoviesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoriteMoviesRepository extends JpaRepository<UserFavoriteMovies, UserFavoriteMoviesId> {
    // Custom query method to find all favorite movies by a specific user
    List<UserFavoriteMovies> findByUserId(Integer userId);
}