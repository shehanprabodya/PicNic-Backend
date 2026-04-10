package com.picnic.backend.Dto;

import com.picnic.backend.entity.Role;
import lombok.Data;

@Data
public class AuthResponseDto {
    
    private Long userId;
    private String userName;
    private Role role;
    private String Email;
}
