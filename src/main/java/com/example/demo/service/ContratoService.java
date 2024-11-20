package com.example.demo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ContratoDTO;
import com.example.demo.entity.Contrato;
import com.example.demo.repository.ContratoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoDTO createContrato(ContratoDTO dto) {
        Contrato contrato = mapToEntity(dto);
        contrato = contratoRepository.save(contrato);
        return mapToDTO(contrato);
    }

    public ContratoDTO updateContrato(Long id, ContratoDTO dto) {
        Contrato contrato = contratoRepository.findById(id).orElseThrow();
        contrato.setIdentificador(dto.getIdentificador());
        contrato.setValor(dto.getValor());
        contrato.setNombreContratante(dto.getNombreContratante());
        contrato.setDocumentoContratante(dto.getDocumentoContratante());
        contrato.setNombreContratantista(dto.getNombreContratantista());
        contrato.setDocumentoContratantista(dto.getDocumentoContratantista());
        contrato.setFechaInicial(dto.getFechaInicial());
        contrato.setFechaFinal(dto.getFechaFinal());
        contrato = contratoRepository.save(contrato);
        return mapToDTO(contrato);
    }

    public void deleteContrato(Long id) {
        contratoRepository.deleteById(id);
    }

    public List<ContratoDTO> getAllContratos() {
        return contratoRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ContratoDTO getContratoById(Long id) {
        Contrato contrato = contratoRepository.findById(id).orElseThrow();
        return mapToDTO(contrato);
    }

    private ContratoDTO mapToDTO(Contrato contrato) {
        ContratoDTO dto = new ContratoDTO();
        dto.setId(contrato.getId());
        dto.setIdentificador(contrato.getIdentificador());
        dto.setValor(contrato.getValor());
        dto.setNombreContratante(contrato.getNombreContratante());
        dto.setDocumentoContratante(contrato.getDocumentoContratante());
        dto.setNombreContratantista(contrato.getNombreContratantista());
        dto.setDocumentoContratantista(contrato.getDocumentoContratantista());
        dto.setFechaInicial(contrato.getFechaInicial());
        dto.setFechaFinal(contrato.getFechaFinal());
        return dto;
    }

    private Contrato mapToEntity(ContratoDTO dto) {
        Contrato contrato = new Contrato();
        contrato.setId(dto.getId());
        contrato.setIdentificador(dto.getIdentificador());
        contrato.setValor(dto.getValor());
        contrato.setNombreContratante(dto.getNombreContratante());
        contrato.setDocumentoContratante(dto.getDocumentoContratante());
        contrato.setNombreContratantista(dto.getNombreContratantista());
        contrato.setDocumentoContratantista(dto.getDocumentoContratantista());
        contrato.setFechaInicial(dto.getFechaInicial());
        contrato.setFechaFinal(dto.getFechaFinal());
        return contrato;
    }
}
