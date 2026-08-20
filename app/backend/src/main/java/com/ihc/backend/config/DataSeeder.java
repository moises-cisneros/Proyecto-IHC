package com.ihc.backend.config;

import com.ihc.backend.entity.Rol;
import com.ihc.backend.entity.Usuario;
import com.ihc.backend.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByEmail("supervisor@gmail.com").isEmpty()) {
            Usuario supervisor = new Usuario();
            supervisor.setEmail("supervisor@gmail.com");
            supervisor.setPassword(passwordEncoder.encode("password123"));
            supervisor.setNombre("Carlos");
            supervisor.setApellido("Supervisor");
            supervisor.setTelefono("65781233");
            supervisor.setRol(Rol.SUPERVISOR);
            usuarioRepository.save(supervisor);
        }
    }
}
