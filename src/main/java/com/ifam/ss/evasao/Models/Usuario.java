/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author luizf
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

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
     * Apenas por questão esteética Para definir o tipo de acesso Reitoria
     * Diretoria Chefe departamento Assistente Social
     */
    @Column(name = "tipo", nullable = false, length = 1)
    private char tipo;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "campus", nullable = false)
    private Campus campus;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento", nullable = false)
    private Departamento departamento;

    /**
     * Matricula do servidor federal
     */
    @Column(name = "siape", nullable = false, unique = true)
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

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    public static Usuario setDadosUpdate(Usuario usuario) {
        Usuario usuarioAux = new Usuario();
        usuarioAux.setNome(usuario.getNome());
        usuarioAux.setSenha(usuario.getSenha());
        usuarioAux.setSiape(usuario.getSiape());
        usuarioAux.setTipo(usuario.getTipo());
        usuarioAux.setUsuario(usuario.getUsuario());
        usuarioAux.setCampus(usuario.getCampus());
        usuarioAux.setDepartamento(usuario.getDepartamento());
        return usuarioAux;
    }

}
