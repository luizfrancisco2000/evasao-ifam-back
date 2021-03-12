/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Controller;

import com.ifam.ss.evasao.Models.Campus;
import com.ifam.ss.evasao.Repository.CampusRepository;
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
public class CampusController{
    @Autowired
    CampusRepository campusRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/campuss")
    public ResponseEntity<?> getCampus() {
        return new ResponseEntity<>(campusRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/campus/{id}")
    public ResponseEntity<?> getCampusId(@PathVariable("id") Long campusId) {
        return new ResponseEntity<>(campusRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/campus")
    public ResponseEntity<?> insertCampus(@RequestBody Campus campus) {
        return new ResponseEntity<>(campusRepository.save(campus), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/campus")
    public ResponseEntity<?> updateCampus(@RequestBody Campus campus) {
        Campus campusAux = campusRepository.findById(campus.getId()).get();
        campusAux = Campus.setDadosUpdate(campusAux);
        return new ResponseEntity<>(campusRepository.save(campusAux), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/campus")
    public ResponseEntity<?> deleteCampus(@RequestBody Campus campus) {
        Campus campusAux = campusRepository.findById(campus.getId()).get();
        campusRepository.delete(campusAux);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
    
}
