package com.bestmovies.bestmoviesinc.Controller;

import com.bestmovies.bestmoviesinc.Entity.Comments;
import com.bestmovies.bestmoviesinc.Entity.User;
import com.bestmovies.bestmoviesinc.Service.CommentsService;
import com.bestmovies.bestmoviesinc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentsController {

    @Autowired
    private CommentsService commentsService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Comments> addComment(@RequestBody Map<String, Object> commentData) {
        Integer userId = (Integer) commentData.get("userId");
        Integer movieId = (Integer) commentData.get("movieId");
        String commentText = (String) commentData.get("comment");

        // Find the user by ID
        Optional<User> userOptional = userService.findUserById(userId);
        if (!userOptional.isPresent()) {
            return ResponseEntity.badRequest().body(null);  // Return a 400 Bad Request if user is not found
        }

        // Create the Comments object
        Comments comment = new Comments();
        comment.setUser(userOptional.get());
        comment.setMovieId(movieId);
        comment.setComment(commentText);

        Comments newComment = commentsService.addComment(comment);
        return ResponseEntity.ok(newComment);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Comments>> getCommentsByMovieId(@PathVariable Integer movieId) {
        List<Comments> comments = commentsService.getCommentsByMovieId(movieId);
        if (comments.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content if no comments found
        }
        return ResponseEntity.ok(comments);
    }


    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Integer commentId) {
        commentsService.deleteCommentById(commentId);
        return ResponseEntity.noContent().build();
    }
}
