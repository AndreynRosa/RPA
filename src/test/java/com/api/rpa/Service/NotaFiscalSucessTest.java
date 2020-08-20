package com.api.rpa.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import com.api.rpa.Utils.EntityUtils;
import com.api.rpa.error.InternalServerError;
import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.model.Entity.NotaFiscalEntity;
import com.api.rpa.repository.NotaFiscalRepository;
import com.api.rpa.service.EmpresaSarvice;
import com.api.rpa.service.NotaFiscalService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

public class NotaFiscalSucessTest {

    private EntityUtils entityUtils;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        entityUtils = new EntityUtils();
        mockService = Mockito.mock(NotaFiscalService.class);
        mockRepository = Mockito.mock(NotaFiscalRepository.class);
        mockEmpresaService = Mockito.mock(EmpresaSarvice.class);
    }

    @MockBean
    private NotaFiscalRepository mockRepository;

    @InjectMocks
    private NotaFiscalService mockService;

    @InjectMocks
    private EmpresaSarvice mockEmpresaService;

    @Test
    public void checkIfValorIsValidTest() {
        Mockito.doThrow(new RuntimeException()).when(mockService).checkIfValorIsValid(null);
        mockService.checkIfValorIsValid(new BigDecimal("1000.20"));
        Assertions.assertThrows(RuntimeException.class, () -> {
            mockService.checkIfValorIsValid(null);
        });
    }

    @Test
    public void checkIfNumeroIsValidTest() {
        final String number = "";
        Mockito.doThrow(new RuntimeException()).when(mockService).checkIfNumeroIsValid(number);
        mockService.checkIfNumeroIsValid("1231231231232");
        Assertions.assertThrows(RuntimeException.class, () -> {
            mockService.checkIfNumeroIsValid(number);
        });
    }

    @Test
    public void checkIfEmpresasAreSameTest() {
        final EmpresaEntity prestadora = entityUtils.newEmpresa("Prestadora", "2222339009407");
        final EmpresaEntity tomadora = entityUtils.newEmpresa("Tomadora", "4545412339009407");

        prestadora.setId(1);
        tomadora.setId(2);

        Mockito.doThrow(new RuntimeException()).when(mockService).checkIfEmpresasAreSame(tomadora, tomadora);
        mockService.checkIfEmpresasAreSame(tomadora, prestadora);
        Assertions.assertThrows(RuntimeException.class, () -> {
            mockService.checkIfEmpresasAreSame(tomadora, tomadora);
        });
    }

    @Test
    public void checkIfDataIsValidTest() {
        final Date date = new Date();

        Mockito.doThrow(new RuntimeException()).when(mockService).checkIfDataIsValid(null);
        mockService.checkIfDataIsValid(date);
        Assertions.assertThrows(RuntimeException.class, () -> {
            mockService.checkIfDataIsValid(null);
        });

    }

    @Test
    public void save() throws InternalServerError {

        final EmpresaEntity prestadora = entityUtils.newEmpresa("Prestadora", "2222339009407");
        final EmpresaEntity tomadora = entityUtils.newEmpresa("Tomadora", "4545412339009407");

        prestadora.setId(1);
        tomadora.setId(2);

        final NotaFiscalEntity notaMock = entityUtils.newNotaFiscalT(tomadora, prestadora);
        final NotaFiscalEntity nota = entityUtils.newNotaFiscalT(tomadora, prestadora);
        Mockito.when(mockService.save(tomadora.getId(), prestadora.getId(), nota)).thenReturn(notaMock);
        final NotaFiscalEntity nf = mockService.save(tomadora.getId(), prestadora.getId(), nota);
        assertTrue(!nf.getEmpresaPrestadora().equals(nf.getEmpresaTomadora()));
    }

}
