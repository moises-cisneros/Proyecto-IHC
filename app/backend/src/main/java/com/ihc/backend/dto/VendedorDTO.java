package com.ihc.backend.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class VendedorDTO {
    private UUID id;
    private String nombreCompleto;
    private String estado;
    private String ubicacion;
    private Double latitud;
    private Double longitud;
    private LocalDateTime ultimaConexion;
}
