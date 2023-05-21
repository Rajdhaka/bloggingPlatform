package com.geekster.bloggingPlatform.services;

import com.geekster.bloggingPlatform.models.BlogFollowing;
import com.geekster.bloggingPlatform.models.User;
import com.geekster.bloggingPlatform.repositories.IFollowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
    @Autowired
    IFollowingRepo followingRepo;

    public void saveFollowing(User myUser, User otherUser) {
        BlogFollowing followingRecord = new BlogFollowing(null,myUser,otherUser);
        followingRepo.save(followingRecord);
    }



}
