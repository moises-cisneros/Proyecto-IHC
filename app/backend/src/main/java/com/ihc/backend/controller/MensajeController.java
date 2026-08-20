package com.ihc.backend.controller;

import com.ihc.backend.dto.MensajeRequestDTO;
import com.ihc.backend.service.MensajeService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;

    @PostMapping("/enviar/{vendedorId}")
    public ResponseEntity<?> enviarMensaje(
            @PathVariable String vendedorId,
            @RequestBody MensajeRequestDTO request,
            Principal principal) {
        try {
            Map<String, String> response = mensajeService.enviarMensaje(vendedorId, request, principal.getName());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
