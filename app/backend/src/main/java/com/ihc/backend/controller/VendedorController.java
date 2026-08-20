package com.ihc.backend.controller;

import com.ihc.backend.dto.VendedorDTO;
import com.ihc.backend.service.VendedorService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> getVendedores() {
        List<VendedorDTO> vendedores = vendedorService.getVendedores();
        return ResponseEntity.ok(vendedores);
    }
}
