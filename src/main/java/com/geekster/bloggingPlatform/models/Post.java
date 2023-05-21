package com.geekster.bloggingPlatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    //    @Column(nullable = false)
    private LocalDateTime createdDate;


    //    @Column(nullable = false)
    private String postData;

    private String postTitle;

    //add regex here
    private String location;


    @ManyToOne()// remove this ...not needed...why ??
    @JoinColumn(name = "fk_user_ID")
    private User user;

}

