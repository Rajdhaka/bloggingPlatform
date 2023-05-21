package com.geekster.bloggingPlatform.controllers;

import com.geekster.bloggingPlatform.models.BlogComment;
import com.geekster.bloggingPlatform.models.User;
import com.geekster.bloggingPlatform.services.CommentService;
import com.geekster.bloggingPlatform.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    TokenService authService;

    @PostMapping()
    String addComment(@RequestBody BlogComment comment) {
        return commentService.addComment(comment);
    }

    @GetMapping()
    public List<BlogComment> getAllComment() {
        return commentService.getAllComment();
    }

    @DeleteMapping("commentId/{commentId}")
    public String removeComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }
   @PutMapping
    public ResponseEntity<String> modifyComment(@RequestParam String email, @RequestParam String token, @RequestParam Long commentId, @RequestParam String commentBody) {
        HttpStatus status;
        String msg = "";
        if (authService.authenticate(email, token)) {
            User user = authService.findUserByToken(token);
            commentService.updateComment(email, token, commentId, commentBody);
            msg = " Comment updated successfully";
            status = HttpStatus.OK;
        } else {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg, status);
    }
}
