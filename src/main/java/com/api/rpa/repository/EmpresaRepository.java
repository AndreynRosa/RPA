package com.api.rpa.repository;

import com.api.rpa.model.Entity.EmpresaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {

    Boolean existsByCnpj(String cnpj);

}
