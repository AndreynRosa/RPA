package com.api.rpa.Utils;

import java.math.BigDecimal;
import java.util.Date;

import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.model.Entity.NotaFiscalEntity;

public class EntityUtils {

    public EmpresaEntity newEmpresa(String razaoSocail, String cnpj) {
        EmpresaEntity empresa = new EmpresaEntity();
        empresa.setCnpj(cnpj);
        empresa.setNomeFantasia("nome fantasia");
        empresa.setRazaoSocial("razaoSocail");
        empresa.setAtivo(true);
        return empresa;
    }

    public NotaFiscalEntity newNotaFiscalT(EmpresaEntity tomadora, EmpresaEntity prestadora) {
        NotaFiscalEntity nota = new NotaFiscalEntity();
        nota.setEmpresaPrestadora(prestadora);
        nota.setEmpresaTomadora(tomadora);

        nota.setDataCriacao(new Date());
        nota.setNumero("123123123");
        nota.setValor(new BigDecimal("1500.0"));
        return nota;
    }
}
