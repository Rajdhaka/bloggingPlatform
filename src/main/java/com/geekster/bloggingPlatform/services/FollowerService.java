package com.geekster.bloggingPlatform.services;

import com.geekster.bloggingPlatform.models.BlogFollower;
import com.geekster.bloggingPlatform.models.User;
import com.geekster.bloggingPlatform.repositories.IFollowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    IFollowerRepo followerRepo;
    public void saveFollower(User myUser, User otherUser) {


        BlogFollower follower = new BlogFollower(null,myUser,otherUser);

        followerRepo.save(follower);
    }
}
