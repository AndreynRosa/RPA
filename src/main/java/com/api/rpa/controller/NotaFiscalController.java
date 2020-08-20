package com.api.rpa.controller;

import java.util.List;

import com.api.rpa.model.Entity.NotaFiscalEntity;
import com.api.rpa.service.NotaFiscalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(value = "/v1/nota")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;

    @PostMapping(value = "/{tomadorId}/{prestadorId}")
    public ResponseEntity<NotaFiscalEntity> save(@PathVariable("tomadorId") Integer tomadorId,
            @PathVariable("prestadorId") Integer prestadorId, @RequestBody NotaFiscalEntity nota) {
        return ResponseEntity.ok(service.save(tomadorId, prestadorId, nota));
    }

    @GetMapping(value = "/prestadora/{prestadorId}")
    public ResponseEntity<List<NotaFiscalEntity>> findAllByPrestadora(
            @PathVariable("prestadorId") Integer prestadorId) {
        return ResponseEntity.ok(service.getAllByPrestadoraId(prestadorId));
    }

    @GetMapping(value = "/tomadora/{tomadorId}")
    public ResponseEntity<List<NotaFiscalEntity>> findAllByTomadora(
            @PathVariable("tomadorId") Integer tomadorId) {
        return ResponseEntity.ok(service.getAllByTomadoraId(tomadorId));
    }
}
