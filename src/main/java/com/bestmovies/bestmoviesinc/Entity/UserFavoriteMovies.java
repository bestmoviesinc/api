package com.bestmovies.bestmoviesinc.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
@Entity
@Table(name = "user_favorite_movies", schema = "bestmoviesinc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserFavoriteMovies {

    @EmbeddedId
    private UserFavoriteMoviesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column( nullable = false,insertable = false,updatable = false)
    private Integer movieId;

    // Constructors
    public UserFavoriteMovies() {}

    public UserFavoriteMovies(User user, Integer movieId) {
        this.user = user;
        this.movieId = movieId;
        this.id = new UserFavoriteMoviesId(user.getId(), movieId);
    }

    // Getters and Setters
    public UserFavoriteMoviesId getId() {
        return id;
    }

    public void setId(UserFavoriteMoviesId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}