package com.picnic.backend.entity;

import jakarta.persistence.*;

@Entity

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


}
