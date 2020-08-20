package com.api.rpa.repository;

import java.util.List;

import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.model.Entity.NotaFiscalEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscalEntity, Integer> {

    List<NotaFiscalEntity> findByEmpresaPrestadora(EmpresaEntity empresaTomadora);

}
