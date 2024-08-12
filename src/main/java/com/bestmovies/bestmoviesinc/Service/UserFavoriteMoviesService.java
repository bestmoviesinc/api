package com.bestmovies.bestmoviesinc.Service;

import com.bestmovies.bestmoviesinc.Entity.UserFavoriteMovies;
import com.bestmovies.bestmoviesinc.Entity.UserFavoriteMoviesId;
import com.bestmovies.bestmoviesinc.Repository.UserFavoriteMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavoriteMoviesService {

    @Autowired
    private UserFavoriteMoviesRepository userFavoriteMoviesRepository;

    public UserFavoriteMovies addFavoriteMovie(UserFavoriteMovies favoriteMovie) {
        return userFavoriteMoviesRepository.save(favoriteMovie);
    }

    public List<UserFavoriteMovies> getFavoriteMoviesByUserId(Integer userId) {
        return userFavoriteMoviesRepository.findByUserId(userId);
    }

    public void removeFavoriteMovie(UserFavoriteMoviesId id) {
        userFavoriteMoviesRepository.deleteById(id);
    }
}
