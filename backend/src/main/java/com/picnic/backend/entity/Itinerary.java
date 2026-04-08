package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name="itinerary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itinerary_id")
    private Long itineraryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_itinerary_package"))
    private Travelpackage travelPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_itinerary_destination"))
    private Destination destination;

    @NotNull(message = "Day number cannot be null")
    @Positive(message = "Day number must be greater than 0")
    @Column(name = "day_number", nullable = false)
    private Integer dayNumber;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(name = "description", length = 500)
    private String description;

    @ElementCollection
    @CollectionTable(name = "itinerary_activities", joinColumns = @JoinColumn(name = "itinerary_id"))
    @Column(name = "activity")
    private List<String> activities;

    @Size(max = 100, message = "Meals field cannot exceed 100 characters")
    @Column(name = "meals", length = 100)
    private String meals;

    @Size(max = 255, message = "Accommodation cannot exceed 255 characters")
    @Column(name = "accommodation", length = 255)
    private String accommodation;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
