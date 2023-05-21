package com.geekster.bloggingPlatform.repositories;

import com.geekster.bloggingPlatform.models.BlogFollower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowerRepo extends JpaRepository<BlogFollower,Long> {
}
