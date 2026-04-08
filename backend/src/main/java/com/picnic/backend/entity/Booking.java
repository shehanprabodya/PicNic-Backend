package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @Column (name="booking_Id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", nullable = false, foreignKey = @ForeignKey(name = "fk_booking_user"))
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_booking_package"))
    private Travelpackage travelPackage;

    @CreationTimestamp
    @Column(name = "booking_date", nullable = false, updatable = false)
    private LocalDateTime bookingDate;

    @NotNull(message = "Number of people cannot be null")
    @Positive(message = "Number of people must be greater than 0")
    @Column(name = "number_of_people", nullable = false)
    private Integer numberOfPeople;

    @NotNull(message = "Total price cannot be null")
    @DecimalMin(value = "0.01", message = "Total price must be greater than 0")
    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status = BookingStatus.PENDING;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

    public enum BookingStatus {
        PENDING,      // Booking created, awaiting payment
        CONFIRMED,    // Payment received
        CANCELLED,    // Booking cancelled by customer or system
        COMPLETED     // Trip completed
    }

}
