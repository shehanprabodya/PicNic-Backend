package com.picnic.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destinationdto {

    private Long destinationId;
    private String title;
    private String description;
    private String country;
    private String location;
}
