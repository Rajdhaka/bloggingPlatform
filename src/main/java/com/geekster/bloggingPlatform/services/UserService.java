package com.geekster.bloggingPlatform.services;

import com.geekster.bloggingPlatform.dto.SignInInput;
import com.geekster.bloggingPlatform.dto.SignInOutput;
import com.geekster.bloggingPlatform.dto.SignUpOutput;
import com.geekster.bloggingPlatform.models.AuthenticationToken;
import com.geekster.bloggingPlatform.models.User;
import com.geekster.bloggingPlatform.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    TokenService tokenService;

    @Autowired
    FollowingService followingService;

    @Autowired
    FollowerService followerService;



    public SignUpOutput signUp(User signUpDto) {


        //check if user exists or not based on email
        User user = userRepo.findFirstByEmail(signUpDto.getEmail());

        if(user != null)
        {
            throw new IllegalStateException("BlogPortal user already exists!!!!...sign in instead");
        }

//      encryption
        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        signUpDto.setPassword(encryptedPassword);
        userRepo.save(signUpDto);

        return new SignUpOutput("BlogPortal user registered","BlogPortal account created successfully");

    }
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;

    }

    public SignInOutput signIn(SignInInput signInDto) {
        //check if user exists or not based on email
        User user = userRepo.findFirstByEmail(signInDto.getEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());

    }

    @Transactional
    public String followUser(Long myId, Long otherId) {

        if(myId == otherId)
        {
            return "Cant follow yourself!!!!";
        }
        User myUser = userRepo.findByUserId(myId);
        User otherUser = userRepo.findByUserId(otherId);

        if(myUser!=null && otherUser!=null) {

            //todo : check if already follows or not

            //follow from my side
            followingService.saveFollowing(myUser,otherUser);

            //follower from other side
            followerService.saveFollower(otherUser, myUser);

            return "Followed Successfully!!!!!";
        }
        else
        {
            return "Users are invalid!!!";
        }
    }

}
