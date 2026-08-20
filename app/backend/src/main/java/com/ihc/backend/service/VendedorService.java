package com.ihc.backend.service;

import com.ihc.backend.dto.VendedorDTO;
import com.ihc.backend.entity.VendedorEntity;
import com.ihc.backend.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public List<VendedorDTO> getVendedores() {
        List<VendedorEntity> vendedoresEncontrados = vendedorRepository.findAll();
        List<VendedorDTO> listaVendedores = new ArrayList<>();

        for (VendedorEntity vendedor : vendedoresEncontrados) {
            listaVendedores.add(VendedorDTO.builder()
                    .id(vendedor.getId())
                    .nombreCompleto(
                            vendedor.getUsuario().getNombre() + " " + vendedor.getUsuario().getApellido())
                    .estado(vendedor.getEstado())
                    .ubicacion(vendedor.getUbicacion())
                    .latitud(vendedor.getLatitud())
                    .longitud(vendedor.getLongitud())
                    .ultimaConexion(vendedor.getUltimaConexion())
                    .build());
        }

        return listaVendedores;
    }
}
