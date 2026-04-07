package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigInteger;

@Entity
@Data
@Table (name = "destination")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

    @Id
    @Column (name="destination_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long destinationId;

    @Column(nullable = false)
    private String title;

    /**
     * lob is used for large text
     */
    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String country;
    
    @Column(nullable = false)
    private String location;







}
