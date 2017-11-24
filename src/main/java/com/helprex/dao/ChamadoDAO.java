/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao;

import com.helprex.model.Chamado;

/**
 *
 * @author Gabriel
 */
public interface ChamadoDAO extends DAO<Chamado, Long>{
    Chamado findBycodigo(String codigo);
    
    Chamado findBytitulo(String titulo);
    
    
}
