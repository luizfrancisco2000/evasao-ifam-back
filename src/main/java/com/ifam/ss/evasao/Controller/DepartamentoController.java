/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Controller;

import com.ifam.ss.evasao.Models.Departamento;
import com.ifam.ss.evasao.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author luizf
 */

@RestController
@RequestMapping("/api")
public class DepartamentoController{
    @Autowired
    DepartamentoRepository departamentoRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/departamentos")
    public ResponseEntity<?> getDepartamentos() {
        return new ResponseEntity<>(departamentoRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departamento/{id}")
    public ResponseEntity<?> getDepartamentoId(@PathVariable("id") Long departamentoId) {
        return new ResponseEntity<>(departamentoRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/departamento")
    public ResponseEntity<?> insertDepartamento(@RequestBody Departamento departamento) {
        return new ResponseEntity<>(departamentoRepository.save(departamento), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/departamento")
    public ResponseEntity<?> updateDepartamento(@RequestBody Departamento departamento) {
        Departamento departamentoAux = departamentoRepository.findById(departamento.getId()).get();
        departamentoAux = Departamento.setDadosUpdate(departamentoAux);
        return new ResponseEntity<>(departamentoRepository.save(departamentoAux), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/departamento")
    public ResponseEntity<?> deleteDepartamento(@RequestBody Departamento departamento) {
        Departamento departamentoAux = departamentoRepository.findById(departamento.getId()).get();
        departamentoRepository.delete(departamentoAux);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
