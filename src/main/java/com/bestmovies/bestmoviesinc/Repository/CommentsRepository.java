package com.bestmovies.bestmoviesinc.Repository;

import com.bestmovies.bestmoviesinc.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    List<Comments> findByMovieId(Integer movieId);
}
