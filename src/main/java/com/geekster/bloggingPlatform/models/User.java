package com.geekster.bloggingPlatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotNull
    private String userFirstName;
    @NotNull
    private String userLastName;
    @NotNull
    @Column(unique = true)
    private String blogUserName;
    @NotNull
    private String password;
    @Email
    @NotNull
    private String email;
    @Size(min = 10,max = 12)
    @Pattern( regexp = "\\d{2}-\\d{10}")
    private String phoneNumber;
}

