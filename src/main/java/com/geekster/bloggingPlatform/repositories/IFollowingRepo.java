package com.geekster.bloggingPlatform.repositories;

import com.geekster.bloggingPlatform.models.BlogFollowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowingRepo extends JpaRepository<BlogFollowing,Long> {
}
