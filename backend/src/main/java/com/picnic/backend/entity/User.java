package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table (name = "user",indexes = {
        @Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_role_id", columnList = "role_id")},
        uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id
    @Column (name = "user_Id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank (message = "Username is mandatory")
    @Size (min = 2 , max = 20 ,message = "Username Should not Exceed more than 20 Characters")
    @Column (unique = true,nullable = false)
    private String userName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_role"))
    private Role role;

    @NotBlank (message = "Email is mandatory")
    @Email (message = "email should be valid")
    @Column (unique = true,nullable = false)
    private String Email;

    @NotBlank (message = "Password is mandatory")
    @Size (min = 6 ,message = "password at least 6 characters")
    @Column (nullable = false)
    private String passWord;

    @CreationTimestamp
    @Column (updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private  LocalDateTime updateAt;

    /**
     * One User can have Many Bookings
     * CascadeType.REFRESH: Only refresh the user when needed
     * FetchType.LAZY: Don't load bookings unless explicitly requested
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    /**
     * One User can write Many Reviews
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews;

    /**
     * One User can have Many Wishlist items
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Wishlist> wishlists;

    /**
     * One User can receive Many Notifications
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notifications> notifications;

    /**
     * One User can own One Business (optional)
     * OneToOne relationship
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Business business;


}
