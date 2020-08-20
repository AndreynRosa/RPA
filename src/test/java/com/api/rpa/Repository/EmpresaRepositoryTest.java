package com.api.rpa.Repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.api.rpa.Utils.EntityUtils;
import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.repository.EmpresaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository repository;

    private EntityUtils entityUtils;

    @BeforeEach
    public void init() {
        entityUtils = new EntityUtils();
    }

    @Test
    public void shouldBeCreateEmpresa() {
        EmpresaEntity empresa = entityUtils.newEmpresa("nomeFntasia", "35474205000106");
        EmpresaEntity savedEmpresa = repository.save(empresa);
        assertNotNull(savedEmpresa.getId());
    }

    @Test
    public void shouldBeRemoveEmpresa() {
        EmpresaEntity empresa = entityUtils.newEmpresa("nomeFntasia", "35474205000106");
        EmpresaEntity savedEmpresa = repository.save(empresa);

        Integer idEmpresa = savedEmpresa.getId();

        repository.delete(savedEmpresa);
        EmpresaEntity shoudBeNullEmpresa = repository.findById(idEmpresa).orElse(null);
        assertNull(shoudBeNullEmpresa);
    }

    @Test
    public void shouldBeEditEmpresa() {
        EmpresaEntity empresa = entityUtils.newEmpresa("nomeFntasia", "35474205000106");
        EmpresaEntity savedEmpresa = repository.save(empresa);

        String savedEmpresaName = savedEmpresa.getNomeFantasia();
        Integer savedEmpresaId = savedEmpresa.getId();

        savedEmpresa.setNomeFantasia("nomeFantasia updated");
        EmpresaEntity updatedEmpresa = repository.save(savedEmpresa);

        assertTrue(
                !updatedEmpresa.getNomeFantasia().equals(savedEmpresaName) && updatedEmpresa.getId() == savedEmpresaId);
    }

    @Test
    public void shouldBeChageEmpresToInvalid() {
        EmpresaEntity empresa = entityUtils.newEmpresa("nomeFntasia", "35474205000106");
        EmpresaEntity savedEmpresa = repository.save(empresa);

        savedEmpresa.setAtivo(false);
        EmpresaEntity updatedEmpresa = repository.save(savedEmpresa);
        assertTrue(!updatedEmpresa.getAtivo());
    }

    @Test
    public void existByCnpjTest() {
        EmpresaEntity empresa = entityUtils.newEmpresa("nomeFntasia", "35474205000106");
        EmpresaEntity savedEmpresa = repository.save(empresa);

        Boolean existByCnpj = repository.existsByCnpj(savedEmpresa.getCnpj());
        assertTrue(existByCnpj);
    }
}
