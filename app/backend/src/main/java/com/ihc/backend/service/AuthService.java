package com.ihc.backend.service;

import com.ihc.backend.dto.AuthRequestDTO;
import com.ihc.backend.dto.AuthResponseDTO;
import com.ihc.backend.entity.UsuarioEntity;
import com.ihc.backend.repository.UsuarioRepository;
import com.ihc.backend.security.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDTO login(AuthRequestDTO request) {
        Optional<UsuarioEntity> usuarioEncontrado = usuarioRepository.findByEmail(request.getEmail());

        if (usuarioEncontrado.isPresent()
                && passwordEncoder.matches(request.getPassword(), usuarioEncontrado.get().getPassword())) {

            UsuarioEntity usuario = usuarioEncontrado.get();
            String token = jwtUtil.generateToken(usuario.getEmail(), usuario.getRol().getNombre());

            return AuthResponseDTO.builder()
                    .token(token)
                    .rol(usuario.getRol().getNombre())
                    .nombre(usuario.getNombre())
                    .build();
        }

        throw new RuntimeException("Credenciales inválidas");
    }
}
