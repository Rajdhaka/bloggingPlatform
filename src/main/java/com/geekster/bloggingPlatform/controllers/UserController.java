package com.geekster.bloggingPlatform.controllers;

import com.geekster.bloggingPlatform.dto.SignInInput;
import com.geekster.bloggingPlatform.dto.SignInOutput;
import com.geekster.bloggingPlatform.dto.SignUpOutput;
import com.geekster.bloggingPlatform.models.User;
import com.geekster.bloggingPlatform.services.TokenService;
import com.geekster.bloggingPlatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn( @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg=null;

        if(authService.authenticate(email,token))
        {
            authService.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }
  @PostMapping("/follow/myId/{myId}/otherId/{otherId}")
    String followUser(@PathVariable Long myId, @PathVariable Long otherId)
    {
        return userService.followUser( myId, otherId);
    }


}
