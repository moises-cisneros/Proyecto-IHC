package com.ihc.backend.service;

import com.ihc.backend.dto.AuthRequestDTO;
import com.ihc.backend.dto.AuthResponseDTO;
import com.ihc.backend.entity.Usuario;
import com.ihc.backend.repository.UsuarioRepository;
import com.ihc.backend.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponseDTO login(AuthRequestDTO request) {
        Optional<Usuario> userOpt = usuarioRepository.findByEmail(request.getEmail());

        if (userOpt.isPresent() && passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
            Usuario usuario = userOpt.get();
            String token = jwtUtil.generateToken(usuario.getEmail(), usuario.getRol().name());
            return new AuthResponseDTO(token, usuario.getRol().name(), usuario.getNombre());
        }

        throw new RuntimeException("Credenciales inválidas");
    }
}
