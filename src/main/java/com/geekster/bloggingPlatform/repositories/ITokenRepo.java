package com.geekster.bloggingPlatform.repositories;

import com.geekster.bloggingPlatform.models.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByToken(String token);
}
