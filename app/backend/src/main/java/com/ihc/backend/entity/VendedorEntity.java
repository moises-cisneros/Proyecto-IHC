package com.ihc.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vendedor")
public class VendedorEntity {

    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    private String estado;
    private String ubicacion;
    private Double latitud;
    private Double longitud;
    private Date ultimaConexion;

}
