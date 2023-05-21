package com.geekster.bloggingPlatform.services;

import com.geekster.bloggingPlatform.models.BlogComment;
import com.geekster.bloggingPlatform.models.Post;
import com.geekster.bloggingPlatform.models.User;
import com.geekster.bloggingPlatform.repositories.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public String addComment(BlogComment comment) {
        User user = comment.getUser();
        comment.setUser(user);

        Post post = comment.getPost();
        comment.setPost(post);
        BlogComment rComment = commentRepo.save(comment);

        if(rComment == null)
        {
            return "Comment not saved...!";
        }
        else
        {
            return "Comment saved...!";
        }
    }

    public List<BlogComment> getAllComment() {
        return commentRepo.findAll();
    }

    public String deleteComment(Long commentId) {
        boolean validOrNot = commentRepo.existsById(commentId);
        if(validOrNot){
            commentRepo.deleteById(commentId);
            return "Comment Deleted Successfully";
        }
        return "Comment not Deleted";
    }

    public void updateComment(String email, String token, Long commentId, String commentBody) {
        BlogComment comment = commentRepo.getById(commentId);
        User  postUser = comment.getUser();
        String newEmail = postUser.getEmail();
        comment.setCommentBody(commentBody);
       commentRepo.save(comment);
    }
}
