/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Controller;

import com.ifam.ss.evasao.Models.Aluno;
import com.ifam.ss.evasao.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

/**
 *
 * @author luizf
 */
@RestController
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/alunos")
    public ResponseEntity<?> getAlunos() {
        return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/aluno/{id}")
    public ResponseEntity<?> getAlunoId(@PathVariable("id") Long alunoId) {
        return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/aluno")
    public ResponseEntity<?> insertAluno(@RequestBody Aluno aluno) {
        return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/aluno")
    public ResponseEntity<?> updateAluno(@RequestBody Aluno aluno) {
        Aluno alunoAux = alunoRepository.findById(aluno.getId()).get();
        alunoAux = Aluno.setDadosUpdate(alunoAux);
        return new ResponseEntity<>(alunoRepository.save(alunoAux), HttpStatus.OK);
    }
}
