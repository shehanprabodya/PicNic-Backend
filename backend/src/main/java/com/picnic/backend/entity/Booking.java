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




}
