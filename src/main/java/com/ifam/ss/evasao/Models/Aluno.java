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
@Table(name="aluno")
public class Aluno implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
     @Column(table = "nome", columnDefinition = "String")
     private String nome;
}
