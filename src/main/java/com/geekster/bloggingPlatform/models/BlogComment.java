package com.geekster.bloggingPlatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentBody;

    @ManyToOne
    @JoinColumn(name ="fk_post_Id")
    @NotNull
    private Post post;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "fk_user_Id")
    private User user;
}
