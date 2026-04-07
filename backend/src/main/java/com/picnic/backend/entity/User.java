package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @Column (name = "user_Id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank (message = "Username is mandatory")
    @Size (min = 2 , max = 20 ,message = "Username Should not Exceed more than 20 Characters")
    @Column (unique = true,nullable = false)
    private String userName;

    @NotBlank (message = "Email is mandatory")
    @Email (message = "email should be valid")
    @Column (unique = true,nullable = false)
    private String Email;

    @NotBlank (message = "Password is mandatory")
    @Size (min = 6 ,message = "password at least 6 characters")
    @Column (nullable = false)
    private String passWord;

    @Column (updatable = false)
    private LocalDateTime createdAt;


    private  LocalDateTime updateAt;


}
