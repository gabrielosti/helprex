/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao;

import com.helprex.model.Acao;

/**
 *
 * @author Gabriel
 */
public interface AcaoDAO extends DAO<Acao, Long >{
    Acao findBytexto(String texto);
}
