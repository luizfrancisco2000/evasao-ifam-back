/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Repository;

import com.ifam.ss.evasao.Models.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author luizf
 */
public interface CampusRepository extends JpaRepository<Campus,Long>{
    //Classe de Permissão de acesso a Campuss administrativos
}

