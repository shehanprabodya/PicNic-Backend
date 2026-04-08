package com.picnic.backend.entity;

import jakarta.persistence.*;
import lombok.*;

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

    



}
