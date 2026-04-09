package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Table (name = "destination")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Destination {

    @Id
    @Column (name="destination_Id")
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


    /**
     * One Destination can have Many Itineraries
     * CascadeType.REFRESH: Don't delete destination if itineraries exist
     */
    @OneToMany(mappedBy = "destination", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<Itinerary> itineraries;




}
