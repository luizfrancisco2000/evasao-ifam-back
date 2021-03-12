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
@Table(name="campus")
public class Campus implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;
    
    @Column(name = "sigla", nullable = false, length = 5)
    private String sigla;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campus")
    private List<Departamento> departamentos;

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

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    
}
