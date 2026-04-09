package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table (name ="travel_package", indexes = {
        @Index(name = "idx_business_id", columnList = "business_id"),
        @Index(name = "idx_title", columnList = "title")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Travelpackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long packageId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "business_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_package_business"))
    private Business business;

    @NotBlank(message = "Package title cannot be blank")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull(message = "Duration cannot be null")
    @Positive(message = "Duration must be greater than 0")
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @NotNull(message = "Max capacity cannot be null")
    @Positive(message = "Max capacity must be greater than 0")
    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;

    @Column(name = "rating", precision = 3, scale = 2)
    private BigDecimal rating = BigDecimal.ZERO;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * One Package can have Many Bookings
     * CascadeType.REFRESH: Don't delete package if bookings exist
     */
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    /**
     * One Package can have Many Reviews
     * CascadeType.ALL: Delete reviews when package is deleted
     */
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews;

    /**
     * One Package can have Many Itineraries (day-by-day breakdown)
     * CascadeType.ALL: Delete itineraries when package is deleted
     */
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Itinerary> itineraries;

    /**
     * One Package can have Many Images
     * CascadeType.ALL: Delete images when package is deleted
     */
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TravelPackageImage> images;

    /**
     * One Package can have Many Availability Records
     * CascadeType.ALL: Delete availability when package is deleted
     */
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Package_Availabillity> availabilities;


}
