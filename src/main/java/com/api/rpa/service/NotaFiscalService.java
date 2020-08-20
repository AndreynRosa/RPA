package com.api.rpa.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.rpa.error.ParamRequestException;
import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.model.Entity.NotaFiscalEntity;
import com.api.rpa.model.Enum.MessageErrorEnum;
import com.api.rpa.repository.NotaFiscalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaFiscalService {

    @Autowired
    private EmpresaSarvice empresaSarvice;

    @Autowired
    private NotaFiscalRepository repository;

    public NotaFiscalEntity save(Integer empresaTomadoraId, Integer empresaPrestadoraId,
            NotaFiscalEntity notaFiscalnotaFiscal) {
        EmpresaEntity empresaTomadora = empresaSarvice.findById(empresaTomadoraId);
        EmpresaEntity empresaPrestadora = empresaSarvice.findById(empresaPrestadoraId);

        notaFiscalnotaFiscal.setEmpresaPrestadora(empresaPrestadora);
        notaFiscalnotaFiscal.setEmpresaTomadora(empresaTomadora);
        assertSaveNotaFiscal(notaFiscalnotaFiscal);

        try {
            return repository.save(notaFiscalnotaFiscal);
        } catch (Exception e) {
            throw new ParamRequestException(MessageErrorEnum.UNOKW_ERROR.toString());
        }
    }

    public List<NotaFiscalEntity> getAllByPrestadoraId(Integer empresaPrestadoraId) {
        EmpresaEntity empresaEntity = empresaSarvice.findById(empresaPrestadoraId);
        empresaSarvice.checkIfEmpresaIsValid(empresaEntity);

        return repository.findByEmpresaPrestadora(empresaEntity);
    }
    public List<NotaFiscalEntity> getAllByTomadoraId(Integer tomadoraId){
        EmpresaEntity empresaEntity = empresaSarvice.findById(tomadoraId);
        empresaSarvice.checkIfEmpresaIsValid(empresaEntity);

        return repository.findByEmpresaTomadora(empresaEntity);

    }

    private void assertSaveNotaFiscal(NotaFiscalEntity notaFiscal) {
        empresaSarvice.checkIfEmpresaIsValid(notaFiscal.getEmpresaPrestadora());
        empresaSarvice.checkIfEmpresaIsValid(notaFiscal.getEmpresaTomadora());
        checkIfEmpresasAreSame(notaFiscal.getEmpresaPrestadora(), notaFiscal.getEmpresaTomadora());
        checkIfDataIsValid(notaFiscal.getDataCriacao());
        checkIfNumeroIsValid(notaFiscal.getNumero());
        checkIfValorIsValid(notaFiscal.getValor());
    }

    public void checkIfValorIsValid(BigDecimal valor) {
        boolean isValorValid = valor != null || greaterThenZero(valor);
        if (!isValorValid) {
            throw new ParamRequestException(MessageErrorEnum.VALUE_CANT_BE_INVALID.toString());
        }
    }

    private boolean greaterThenZero(BigDecimal valor) {
        return valor.compareTo(BigDecimal.ZERO) > 0;
    }

    public void checkIfNumeroIsValid(String numero) {
        boolean isValidNumber = numero != "" && numero != null;
        if (!isValidNumber) {
            throw new ParamRequestException(MessageErrorEnum.NUMBER_CANT_BE_NULL.toString());
        }
    }

    public void checkIfDataIsValid(Date dataCriacao) {
        boolean isValidDate = !dataCriacao.equals(null);
        if (!isValidDate) {
            throw new ParamRequestException(MessageErrorEnum.DATE_CANT_BE_NULL.toString());
        }
    }

    public void checkIfEmpresasAreSame(EmpresaEntity tomadora, EmpresaEntity prestadora) {
        boolean areSameEmpresa = tomadora.equals(prestadora) || tomadora.getId() == prestadora.getId();
        if (areSameEmpresa) {
            throw new ParamRequestException(MessageErrorEnum.COMPANY_CANT_BE_THE_SAME.toString());
        }
    }
}
