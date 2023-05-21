package com.geekster.bloggingPlatform.repositories;

import com.geekster.bloggingPlatform.models.Post;
import com.geekster.bloggingPlatform.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);
}
