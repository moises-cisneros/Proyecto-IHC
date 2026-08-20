package com.ihc.backend.config;

import com.ihc.backend.entity.RolEntity;
import com.ihc.backend.entity.UsuarioEntity;
import com.ihc.backend.entity.VendedorEntity;
import com.ihc.backend.repository.UsuarioRepository;
import com.ihc.backend.repository.VendedorRepository;
import com.ihc.backend.util.EstadoType;
import com.ihc.backend.util.RolType;
import com.ihc.backend.repository.RolRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.core.annotation.Order;

@Component
@Order(2)
@RequiredArgsConstructor
public class VendedorSeeder implements CommandLineRunner {

        private final UsuarioRepository usuarioRepository;
        private final RolRepository rolRepository;
        private final PasswordEncoder passwordEncoder;
        private final VendedorRepository vendedorRepository;

        @Override
        public void run(String... args) throws Exception {
                RolEntity rolVendedor = rolRepository.findByNombre(RolType.VENDEDOR.name()).orElseThrow();

                if (usuarioRepository.findByEmail("juan.perez@gmail.com").isEmpty()) {
                        UsuarioEntity usuario1 = UsuarioEntity.builder()
                                        .email("juan.perez@gmail.com")
                                        .password(passwordEncoder.encode("password123"))
                                        .nombre("Juan")
                                        .apellido("Perez")
                                        .telefono("71122334")
                                        .rol(rolVendedor)
                                        .build();
                        usuarioRepository.save(usuario1);

                        VendedorEntity vendedor1 = VendedorEntity.builder()
                                        .usuario(usuario1)
                                        .estado(EstadoType.ACTIVO.name())
                                        .ubicacion("Barrio Equipetrol, Calle 3")
                                        .latitud(-17.766123)
                                        .longitud(-63.197234)
                                        .build();
                        vendedorRepository.save(vendedor1);
                }

                if (usuarioRepository.findByEmail("maria.gomez@gmail.com").isEmpty()) {
                        UsuarioEntity usuario2 = UsuarioEntity.builder()
                                        .email("maria.gomez@gmail.com")
                                        .password(passwordEncoder.encode("password123"))
                                        .nombre("Maria")
                                        .apellido("Gomez")
                                        .telefono("72233445")
                                        .rol(rolVendedor)
                                        .build();
                        usuarioRepository.save(usuario2);

                        VendedorEntity vendedor2 = VendedorEntity.builder()
                                        .usuario(usuario2)
                                        .estado(EstadoType.ACTIVO.name())
                                        .ubicacion("Mercado Los Pozos")
                                        .latitud(-17.780123)
                                        .longitud(-63.178234)
                                        .build();
                        vendedorRepository.save(vendedor2);
                }

                if (usuarioRepository.findByEmail("carlos.ruiz@gmail.com").isEmpty()) {
                        UsuarioEntity usuario3 = UsuarioEntity.builder()
                                        .email("carlos.ruiz@gmail.com")
                                        .password(passwordEncoder.encode("password123"))
                                        .nombre("Carlos")
                                        .apellido("Ruiz")
                                        .telefono("73344556")
                                        .rol(rolVendedor)
                                        .build();
                        usuarioRepository.save(usuario3);

                        VendedorEntity vendedor3 = VendedorEntity.builder()
                                        .usuario(usuario3)
                                        .estado(EstadoType.INACTIVO.name())
                                        .ubicacion("Plan 3000, Avenida Principal")
                                        .latitud(-17.821123)
                                        .longitud(-63.151234)
                                        .build();
                        vendedorRepository.save(vendedor3);
                }
        }
}
