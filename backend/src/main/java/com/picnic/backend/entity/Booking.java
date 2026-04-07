package com.picnic.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @Column (name="booking_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long bookingId;

    
}
