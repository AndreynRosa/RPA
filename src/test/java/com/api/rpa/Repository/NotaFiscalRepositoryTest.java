package com.api.rpa.Repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.api.rpa.Utils.EntityUtils;
import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.model.Entity.NotaFiscalEntity;
import com.api.rpa.repository.EmpresaRepository;
import com.api.rpa.repository.NotaFiscalRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class NotaFiscalRepositoryTest {

    @Autowired
    private NotaFiscalRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private EntityUtils utils;

    @BeforeEach
    public void init() {
        utils = new EntityUtils();
    }

    @Test
    public void shoudBeSaved() {
        EmpresaEntity tomadora = utils.newEmpresa("Tomadora", "35474205000106");
        EmpresaEntity prestadora = utils.newEmpresa("Prestadora", "35472325000106");

        NotaFiscalEntity nota = utils.newNotaFiscalT(tomadora, prestadora);

        NotaFiscalEntity savedNotaFiscal = repository.save(nota);
        assertNotNull((savedNotaFiscal.getId()));
    }

    @Test
    public void shouldBeEdited() {
        EmpresaEntity tomadora = utils.newEmpresa("Tomadora", "35474205000106");
        EmpresaEntity prestadora = utils.newEmpresa("Prestadora", "35472325000106");

        NotaFiscalEntity nota = utils.newNotaFiscalT(tomadora, prestadora);
        NotaFiscalEntity savedNotaFiscal = repository.save(nota);

        String numero = savedNotaFiscal.getNumero();
        savedNotaFiscal.setNumero("00000000000000000");

        NotaFiscalEntity updatedNota = repository.save(savedNotaFiscal);
        assertTrue(!numero.equals(updatedNota.getNumero()) && savedNotaFiscal.getId().equals(updatedNota.getId()));
    }
}
