package com.geekster.bloggingPlatform.repositories;

import com.geekster.bloggingPlatform.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);

    User findByUserId(Long id);
}
