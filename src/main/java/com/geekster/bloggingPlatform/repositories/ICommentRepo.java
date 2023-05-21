package com.geekster.bloggingPlatform.repositories;

import com.geekster.bloggingPlatform.models.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<BlogComment,Long> {
}
