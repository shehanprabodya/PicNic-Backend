package com.picnic.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Entity
@Table(name = "travel_package_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_image_package"))
    private Travelpackage travelPackage;

    @NotBlank(message = "Image URL cannot be blank")
    @URL(message = "Image URL must be valid")
    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;

    @Size(max = 255, message = "Alt text cannot exceed 255 characters")
    @Column(name = "alt_text", length = 255)
    private String altText;

    @CreationTimestamp
    @Column(name = "uploaded_at", nullable = false, updatable = false)
    private LocalDateTime uploadedAt;
}
