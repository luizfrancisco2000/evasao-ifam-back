/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Controller;


import com.ifam.ss.evasao.Models.Usuario;
import com.ifam.ss.evasao.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author luizf
 */
@RestController
@RequestMapping("/api")
public class UsuarioController{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/usuarios")
    public ResponseEntity<?> getUsuarios() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/usuario/{id}")
    public ResponseEntity<?> getUsuarioId(@PathVariable("id") Long usuarioId) {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/usuario")
    public ResponseEntity<?> insertUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/usuario")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAux = usuarioRepository.findById(usuario.getId()).get();
        usuarioAux = Usuario.setDadosUpdate(usuarioAux);
        return new ResponseEntity<>(usuarioRepository.save(usuarioAux), HttpStatus.OK);
    }
    
        @RequestMapping(method = RequestMethod.DELETE, path = "/usuario")
    public ResponseEntity<?> deleteUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAux = usuarioRepository.findById(usuario.getId()).get();
        usuarioRepository.delete(usuarioAux);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
