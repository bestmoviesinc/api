package com.bestmovies.bestmoviesinc.Entity;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFavoriteMoviesId implements Serializable {

    private Integer userId;
    private Integer movieId;

    // Constructors
    public UserFavoriteMoviesId() {}

    public UserFavoriteMoviesId(Integer userId, Integer movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFavoriteMoviesId that = (UserFavoriteMoviesId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, movieId);
    }
}
