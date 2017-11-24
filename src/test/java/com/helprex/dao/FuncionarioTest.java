/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao;

import com.helprex.dao.impl.FuncionarioDAOImpl;
import com.helprex.model.Funcionario;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Gabriel
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({FuncionarioDAOImpl.class})
public class FuncionarioTest {

    private static final Funcionario F_FERNANDO;

    @Inject
    private FuncionarioDAO funcionarioDAO;

    static {
        F_FERNANDO = new Funcionario("1", "Fernando", "102.333.419-43");
    }
    
    @Test
    public void injectionTest() {
        Assert.assertNotNull(funcionarioDAO);
    }    

    @Test
    public void saveTest() {
        Funcionario funcionario = funcionarioDAO.findBycodigoInterno(F_FERNANDO.getCodigoInterno());
        if (funcionario == null) {
            funcionarioDAO.save(F_FERNANDO);
            funcionario = funcionarioDAO.findBycodigoInterno(F_FERNANDO.getCodigoInterno());
        }
        Assert.assertNotNull(funcionario);
    }
}
