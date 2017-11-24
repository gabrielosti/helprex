/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao;

import com.helprex.model.TipoChamado;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface TipoChamadoDAO extends DAO<TipoChamado, Long> {

    List<TipoChamado> findByNome(String nome);

}
