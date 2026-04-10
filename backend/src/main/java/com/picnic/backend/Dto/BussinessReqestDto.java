package com.picnic.backend.Dto;

import com.picnic.backend.entity.User;
import lombok.Data;

@Data
public class BussinessReqestDto {

    private Long businessId;
    private User user;
    private String business_name;
    private String email;
    private String address;
}
