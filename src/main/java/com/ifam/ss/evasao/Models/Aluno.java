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
@Table(name="aluno")
public class Aluno implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
     @Column(table = "nome", columnDefinition = "String")
     private String nome;
     
    @Column(name="matricula", nullable = false, unique = true)
    private Long matricula;
    
    @Column(name="identidade", nullable = false, unique = true)
    private Long identidade;
    
    @Column(name="cpf", nullable = false, unique = true)
    private Long cpf;
    
    @Column(name="cep", nullable = false)
    private Long cep;
    
    @Column(name="endereco", nullable = false, length = 255)
    private String cndereco;
    
    @Column(name="uf", nullable = false, length = 2)
    private String uf;
    
    @Column(name="cidade", nullable = false, length = 60)
    private String cidade;
    
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name = "curso", nullable = false)
    private Curso curso;

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

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Long getIdentidade() {
        return identidade;
    }

    public void setIdentidade(Long identidade) {
        this.identidade = identidade;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getCndereco() {
        return cndereco;
    }

    public void setCndereco(String cndereco) {
        this.cndereco = cndereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public static Aluno setDadosUpdate(Aluno aluno){
        Aluno alunoAux = new Aluno();
        alunoAux.setCep(aluno.getCep());
        alunoAux.setCidade(aluno.getCidade());
        aluno.setCndereco(aluno.getCndereco());
        aluno.setCpf(aluno.getCpf());
        aluno.setCurso(aluno.getCurso());
        aluno.setIdentidade(aluno.getIdentidade());
        aluno.setMatricula(aluno.getMatricula());
        aluno.setNome(aluno.getNome());
        aluno.setUf(aluno.getUf());
        return alunoAux;
    }
}
