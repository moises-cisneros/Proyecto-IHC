package com.ihc.backend.service;

import com.ihc.backend.dto.MensajeRequestDTO;
import com.ihc.backend.entity.MensajeEntity;
import com.ihc.backend.entity.VendedorEntity;
import com.ihc.backend.entity.UsuarioEntity;
import com.ihc.backend.repository.MensajeRepository;
import com.ihc.backend.repository.UsuarioRepository;
import com.ihc.backend.repository.VendedorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MensajeService {

    private final MensajeRepository mensajeRepository;
    private final VendedorRepository vendedorRepository;
    private final UsuarioRepository usuarioRepository;

    public Map<String, String> enviarMensaje(String vendedorId, MensajeRequestDTO request, String supervisorEmail) {
        Optional<VendedorEntity> vendedorEncontrado = vendedorRepository.findById(UUID.fromString(vendedorId));

        if (vendedorEncontrado.isEmpty()) {
            throw new RuntimeException("Vendedor no encontrado");
        }

        Optional<UsuarioEntity> supervisorEncontrado = usuarioRepository.findByEmail(supervisorEmail);
        if (supervisorEncontrado.isEmpty()) {
            throw new RuntimeException("Supervisor no encontrado");
        }

        MensajeEntity nuevoMensaje = MensajeEntity.builder()
                .vendedor(vendedorEncontrado.get())
                .supervisor(supervisorEncontrado.get())
                .contenido(request.getMensaje())
                .tipo(request.getTipo())
                .hora(new Time(System.currentTimeMillis()))
                .fecha(new Date(System.currentTimeMillis()))
                .build();

        mensajeRepository.save(nuevoMensaje);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Mensaje enviado correctamente.");

        return response;
    }
}
