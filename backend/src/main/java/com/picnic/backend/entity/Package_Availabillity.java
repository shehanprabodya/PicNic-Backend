package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "package_availability")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package_Availabillity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_id")
    private Long availabilityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_availability_package"))
    private Travelpackage travelPackage;

    @NotNull(message = "Available date cannot be null")
    @FutureOrPresent(message = "Available date must be today or in the future")
    @Column(name = "available_date", nullable = false)
    private LocalDate availableDate;

    @NotNull(message = "Available slots cannot be null")
    @Min(value = 0, message = "Available slots cannot be negative")
    @Column(name = "available_slots", nullable = false)
    private Integer availableSlots;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
