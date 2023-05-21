package com.geekster.bloggingPlatform.services;

import com.geekster.bloggingPlatform.models.Post;
import com.geekster.bloggingPlatform.models.User;
import com.geekster.bloggingPlatform.repositories.IPostRepo;
import com.geekster.bloggingPlatform.repositories.ITokenRepo;
import com.geekster.bloggingPlatform.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;

    @Autowired
    ITokenRepo tokenRepo;

    @Autowired
    IUserRepo userRepo;

    public void addPost(Post post) {
        postRepo.save(post);
    }

    public List<Post> getAllPosts(String token) {
        User user = tokenRepo.findFirstByToken(token).getUser();


        List<Post> postList = postRepo.findByUser(user);

        return postList;

    }

    public void updatePost(String email, String token, Long postId, String postTitle) {
        Post post = postRepo.getById(postId);
        User  postUser = post.getUser();
        String newEmail = postUser.getEmail();
        if(newEmail.equals(email)){
            post.setPostTitle(postTitle);
            postRepo.save(post);
        }
    }

    public void deletePost(String email, String token, Long postId) {
        Post post = postRepo.getById(postId);
        User  postUser = post.getUser();
        String newEmail = postUser.getEmail();
        if(newEmail.equals(email)){
            postRepo.deleteById(postId);
        }
    }
}
