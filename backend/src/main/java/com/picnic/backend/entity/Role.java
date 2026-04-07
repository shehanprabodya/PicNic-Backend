package com.picnic.backend.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

/**
 * uniqueConstraints use for avoid duplication of role
 */
@Entity
@Table (name = "role",uniqueConstraints = @UniqueConstraint(columnNames = "roleType"))
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @Column (name = "role_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Enumerated (EnumType.STRING)
    @Column (name = "roleType",nullable = false,unique = true)
    private RoleType roleType;

    /**
     * one role can have many users
     * lazy loading-fetch when only when accessed
     */
    @OneToMany (mappedBy = "role" ,cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<User> user;

    /**
     * role types
     */
    private enum RoleType{
        admin,
        business_owner,
        customer

    }
}
