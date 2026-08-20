package com.ihc.backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponseDTO {
    private String token;
    private String rol;
    private String nombre;
}
