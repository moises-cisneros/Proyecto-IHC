package com.ihc.backend.config;

import com.ihc.backend.entity.RolEntity;
import com.ihc.backend.entity.UsuarioEntity;
import com.ihc.backend.repository.UsuarioRepository;
import com.ihc.backend.util.RolType;
import com.ihc.backend.repository.RolRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByEmail("supervisor@gmail.com").isEmpty()) {

            // Creacion de los roles
            RolEntity rolSupervisor = RolEntity.builder()
                    .nombre(RolType.SUPERVISOR.name())
                    .build();

            RolEntity rolVendedor = RolEntity.builder()
                    .nombre(RolType.VENDEDOR.name())
                    .build();

            rolRepository.save(rolSupervisor);
            rolRepository.save(rolVendedor);

            // Creacion del usuario base
            UsuarioEntity supervisor = UsuarioEntity.builder()
                    .email("supervisor@gmail.com")
                    .password(passwordEncoder.encode("password123"))
                    .nombre("Carlos")
                    .apellido("Supervisor")
                    .telefono("65781233")
                    .rol(rolSupervisor)
                    .build();
            usuarioRepository.save(supervisor);
        }
    }
}
