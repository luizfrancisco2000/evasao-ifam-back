/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Models;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author luizf
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "usuario", nullable = false, length = 30, unique = true)
    private String usuario;

    @Column(name = "senha", nullable = false, length = 30)
    private String senha;
        
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;
    /**
     * Para definir o tipo de acesso
     * Reitoria
     * Diretoria
     * Chefe departamento
     * Assistente Social
     */
    @Column(name = "tipo", nullable = false, length = 1)
    private char tipo;
    
    /**
     * Matricula do servidor federal
     */
    @Column(name="siape", nullable = false, unique = true)
    private Long siape;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Long getSiape() {
        return siape;
    }

    public void setSiape(Long siape) {
        this.siape = siape;
    }
    
    
    
}
