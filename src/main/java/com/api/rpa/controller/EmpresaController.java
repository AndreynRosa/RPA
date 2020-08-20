package com.api.rpa.controller;

import com.api.rpa.error.InternalServerError;
import com.api.rpa.model.Entity.EmpresaEntity;
import com.api.rpa.service.EmpresaSarvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(value = "/v1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaSarvice service;

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<EmpresaEntity> save(@RequestBody EmpresaEntity empresa) throws InternalServerError {
        return ResponseEntity.ok(service.save(empresa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.ok("OK");
    }

}
