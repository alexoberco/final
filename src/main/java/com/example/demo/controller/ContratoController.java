package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContratoDTO;
import com.example.demo.service.ContratoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contratos")
@RequiredArgsConstructor
public class ContratoController {

    private final ContratoService contratoService;

    @PostMapping
    public ContratoDTO create(@RequestBody ContratoDTO dto) {
        return contratoService.createContrato(dto);
    }

    @PutMapping("/{id}")
    public ContratoDTO update(@PathVariable Long id, @RequestBody ContratoDTO dto) {
        return contratoService.updateContrato(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratoService.deleteContrato(id);
    }

    @GetMapping
    public List<ContratoDTO> getAll() {
        return contratoService.getAllContratos();
    }

    @GetMapping("/{id}")
    public ContratoDTO getById(@PathVariable Long id) {
        return contratoService.getContratoById(id);
    }
}