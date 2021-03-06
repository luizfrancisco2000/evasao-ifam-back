/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author luizf
 */
@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "sigla", nullable = false, length = 5)
    private String sigla;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "campus", nullable = false)
    private Campus campus;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Curso> cursos;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public static Departamento setDadosUpdate(Departamento departamento) {
        Departamento departamentoAux = new Departamento();
        departamentoAux.setCampus(departamento.getCampus());
        departamentoAux.setCursos(departamento.getCursos());
        departamentoAux.setNome(departamento.getNome());
        departamentoAux.setSigla(departamento.getSigla());
        return departamentoAux;
    }
}
