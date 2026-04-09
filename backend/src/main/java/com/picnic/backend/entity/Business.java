package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {

    @Id
    @Column (name="business_id")
    private Long businessId;
    /**
     * one user have only one role cannot have two roles
     * eager fetching is used because when
     */
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="userid", nullable = false,unique = true,foreignKey = @ForeignKey(name = "fk_business_user"))
    private User user;

    @NotBlank(message = "Business name cannot be blank")
    @Size(min = 3, max = 255, message = "Business name must be between 3 and 255 characters")
    @Column(name = "business_name", nullable = false, length = 255)
    private String business_name;

    @Email(message = "Business email should be valid")
    @NotBlank(message = "Business email cannot be blank")
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number must be valid")
    @Column(name = "phoneNo", length = 15)
    private String phoneNo;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @Column(name = "address", length = 255)
    private String address;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * One Business can offer Many Travel Packages
     * CascadeType.ALL: When business is deleted, all packages are deleted
     */
    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Travelpackage> travelPackages;


}
