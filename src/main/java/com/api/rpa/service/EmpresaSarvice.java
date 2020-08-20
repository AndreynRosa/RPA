package com.api.rpa.service;

import java.util.Optional;

import com.api.rpa.error.InternalServerError;
import com.api.rpa.error.ParamRequestException;

import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.model.Enum.MessageErrorEnum;
import com.api.rpa.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaSarvice {

    @Autowired
    private EmpresaRepository repository;

    public EmpresaEntity save(EmpresaEntity empresa) throws InternalServerError {
        boolean isNewEmpresa = (empresa.getId() == null || empresa.getId() == 0);
        assertsEmpresaSave(empresa, isNewEmpresa);
        try {
            if (isNewEmpresa) {
                empresa.setAtivo(true);
                return repository.save(empresa);
            } else {
                assertEmpresaAtiva(empresa.getAtivo());
                return repository.save(empresa);
            }
        } catch (Exception e) {
            throw new InternalServerError(MessageErrorEnum.UNOKW_ERROR);
        }
    }

    private void assertEmpresaAtiva(boolean ativo) {
        if (!ativo) {
            throw new ParamRequestException(MessageErrorEnum.ACTIVE_CANT_BE_FALSE.toString());
        }
    }

    private void assertsEmpresaSave(EmpresaEntity empresa, boolean isNewEmpresa) {
        checkIfCnpjIsNotNull(empresa);
        checkIfRazaSocialIsNotNull(empresa);
        checkIfCnpjIsUnique(empresa, isNewEmpresa);
    }

    public void checkIfRazaSocialIsNotNull(EmpresaEntity empresa) {
        if (null == empresa.getRazaoSocial()) {
            throw new ParamRequestException(MessageErrorEnum.RAZAO_SOCIAL_CANT_BE_NULL.toString());
        }
    }

    public void checkIfCnpjIsNotNull(EmpresaEntity empresa) {
        if (null == empresa.getCnpj())
            throw new ParamRequestException(MessageErrorEnum.CNPJ_CANT_BE_NULL.toString());
    }

    public void checkIfCnpjIsUnique(EmpresaEntity empresa, boolean isNewEmpresa) {
        boolean existsByCnpj = repository.existsByCnpj(empresa.getCnpj());
        if (isNewEmpresa && existsByCnpj) {
            throw new ParamRequestException(MessageErrorEnum.CNPJ_ALREADY_EXISTIS.toString());
        }
        if (!isNewEmpresa && existsByCnpj) {
            EmpresaEntity empresaFound = findById(empresa.getId());
            boolean isSameCnpj = empresa.getCnpj().equals(empresaFound.getCnpj());
            if (isSameCnpj) {
                throw new ParamRequestException(MessageErrorEnum.CNPJ_ALREADY_EXISTIS.toString());
            }
        }
    }

    public EmpresaEntity findById(Integer id) {
        Optional<EmpresaEntity> opt = repository.findById(id);
        return opt.orElse(null);
    }

    public void delete(Integer id) {
        EmpresaEntity empresa = findById(id);
        checkIfEmpresaIsValid(empresa);
        empresa.setAtivo(false);
        repository.save(empresa);
    }

    public void checkIfEmpresaIsValid(EmpresaEntity empresa) {
        if (empresa == null || !empresa.getAtivo()) {
            throw new ParamRequestException(MessageErrorEnum.COMPANY_NOT_FOUND.toString());
        }
    }

}
