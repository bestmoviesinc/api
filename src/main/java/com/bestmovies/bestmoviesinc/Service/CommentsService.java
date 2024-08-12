package com.bestmovies.bestmoviesinc.Service;

import com.bestmovies.bestmoviesinc.Entity.Comments;
import com.bestmovies.bestmoviesinc.Repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public Comments addComment(Comments comment) {
        if (comment.getUser() == null) {
            throw new RuntimeException("User cannot be null");
        }
        return commentsRepository.save(comment);
    }



    public List<Comments> getCommentsByMovieId(Integer movieId) {
        return commentsRepository.findByMovieId(movieId);
    }

    public void deleteCommentById(Integer commentId) {
        commentsRepository.deleteById(commentId);
    }
}

