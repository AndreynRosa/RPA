package com.api.rpa.Service;

import com.api.rpa.Utils.EntityUtils;
import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.repository.EmpresaRepository;
import com.api.rpa.service.EmpresaSarvice;

import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class EmpresaServiceTest {

    private EntityUtils entityUtils;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        entityUtils = new EntityUtils();
        mockService = Mockito.mock(EmpresaSarvice.class);
        mockRepository = Mockito.mock(EmpresaRepository.class);
    }

    @MockBean
    private EmpresaRepository mockRepository;

    @InjectMocks
    private EmpresaSarvice mockService;

    @Test
    public void checkIfCnpjIsNotNullTest() {
        final EmpresaEntity empresa = entityUtils.newEmpresa("Razão social", "35474205000106");
        final EmpresaEntity empresaWhitoutCnpj = entityUtils.newEmpresa("Razão social", "35474205000106");
        empresaWhitoutCnpj.setCnpj("");

        Mockito.doThrow(new RuntimeException()).when(mockService).checkIfCnpjIsNotNull(empresaWhitoutCnpj);
        mockService.checkIfCnpjIsNotNull(empresa);
        Assertions.assertThrows(RuntimeException.class, () -> {
            mockService.checkIfCnpjIsNotNull(empresaWhitoutCnpj);
        });

    }

    @Test
    public void checkIfRazaSocialIsNotNullTest() {
        final EmpresaEntity empresa = entityUtils.newEmpresa("Razão social", "35474205000106");
        empresa.setRazaoSocial(null);
        Mockito.doThrow(new RuntimeException()).when(mockService).checkIfRazaSocialIsNotNull(empresa);
        Assertions.assertThrows(RuntimeException.class, () -> {
            mockService.checkIfRazaSocialIsNotNull(empresa);
        });
    }

}
