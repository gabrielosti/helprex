/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao;

import com.helprex.dao.impl.FuncionarioDAOImpl;
import com.helprex.dao.impl.TipoChamadoDAOImpl;
import com.helprex.model.Funcionario;
import com.helprex.model.TipoChamado;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Gabriel
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({TipoChamadoDAOImpl.class, FuncionarioDAOImpl.class})
public class TipoChamadoTest {

    private static final TipoChamado INFRA;
    private static final TipoChamado BD;
    private static final TipoChamado BUG_SISTEMA;

    @Inject
    private TipoChamadoDAO tipoChamadoDAO;

    @Inject
    private FuncionarioDAO funcionarioDAO;

    private List<Funcionario> funcionarios;

    static {
        INFRA = new TipoChamado("Infraestrutura");
        BD = new TipoChamado("Banco de Dados");
        BUG_SISTEMA = new TipoChamado("Bug de Sistema");
    }

    @Before
    public void carregaDados() {
        funcionarios = funcionarioDAO.findAll();
    }

    @Test
    public void injectionTest() {
        Assert.assertNotNull(tipoChamadoDAO);
        Assert.assertNotNull(funcionarioDAO);
    }

    @Test
    public void salvarTiposChamado() {
        persiste(INFRA);
        persiste(BD);
        persiste(BUG_SISTEMA);
    }

    private void persiste(TipoChamado tipoChamado) {
        List<TipoChamado> tipos = tipoChamadoDAO.findByNome(tipoChamado.getNome());
        if (tipos == null || tipos.isEmpty()) {
//            populaRelacionamentos(tipoChamado);
            tipoChamadoDAO.save(tipoChamado);
        } else {
            TipoChamado encontrado = tipos.get(0);
//            populaRelacionamentos(encontrado);
            tipoChamadoDAO.update(encontrado);
        }
        tipos = tipoChamadoDAO.findByNome(tipoChamado.getNome());
        Assert.assertNotNull(tipos);
        Assert.assertEquals(tipos.size(), 1);
    }

    private void populaRelacionamentos(TipoChamado tipoChamado) {
        if (funcionarios != null && !funcionarios.isEmpty()) {
            tipoChamado.getFuncionarios().addAll(funcionarios);
        }
    }
}
