package com.picnic.backend.Dto;

import lombok.Data;

@Data
public class SearchReqestDto {

    private String country;
    private String location;
    private String business_name;
}
