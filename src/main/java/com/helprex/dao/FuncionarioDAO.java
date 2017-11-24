/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao;

import com.helprex.model.Funcionario;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface FuncionarioDAO extends DAO<Funcionario, Long>{
    
    Funcionario findBycodigoInterno(String codigoInterno);
    
    List <Funcionario> findBytiposChamado(String tiposChamado);
    
}
