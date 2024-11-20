package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
