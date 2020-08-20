package com.api.rpa.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @OneToOne
    @JoinColumn(name = "empresa_tomadora_id")
    private EmpresaEntity empresaTomadora;

    @OneToOne
    @JoinColumn(name = "empresa_prestadora_id")
    private EmpresaEntity empresaPrestadora;

}
