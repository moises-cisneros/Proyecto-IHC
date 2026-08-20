package com.ihc.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;
import com.github.f4b6a3.uuid.UuidCreator;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mensaje")
public class MensajeEntity {

    @Id
    private UUID id;

    @PrePersist
    protected void onCreate() {
        if (this.id == null) {
            this.id = UuidCreator.getTimeOrderedEpoch();
        }
    }

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private VendedorEntity vendedor;

    @ManyToOne
    @JoinColumn(name = "supervisor_id", nullable = false)
    private UsuarioEntity supervisor;

    @Column(nullable = false)
    private String contenido;

    private String tipo;
    private Date fecha;
    private Time hora;
}
