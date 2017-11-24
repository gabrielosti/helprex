package com.helprex.dao;

import com.helprex.dao.impl.ChamadoDAOImpl;
import com.helprex.dao.impl.PessoaDAOImpl;
import com.helprex.dao.impl.TipoChamadoDAOImpl;
import com.helprex.model.Acao;
import com.helprex.model.Chamado;
import com.helprex.model.Pessoa;
import com.helprex.model.Prioridade;
import com.helprex.model.Status;
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
@AdditionalClasses({ChamadoDAOImpl.class, TipoChamadoDAOImpl.class, PessoaDAOImpl.class})
public class ChamadoTest {

    private static final Chamado Primeiro_Chamado;

    @Inject
    private ChamadoDAO chamadoDAO;

    @Inject
    private TipoChamadoDAO tipoChamadoDAO;

    @Inject
    private PessoaDAO pessoaDAO;

    private List<TipoChamado> tiposChamados;

    private List<Pessoa> pessoas;

    static {
        Primeiro_Chamado = new Chamado("1", "Telefone", Status.ABERTO, Prioridade.BAIXO);
    }

    @Before
    public void carregaDados() {
        tiposChamados = tipoChamadoDAO.findAll();
        pessoas = pessoaDAO.findAll();
    }

    @Test
    public void injectionTest() {
        Assert.assertNotNull(chamadoDAO);
        Assert.assertNotNull(tipoChamadoDAO);
        Assert.assertNotNull(pessoaDAO);
    }

    @Test
    public void saveTest() {
        Chamado chamado = chamadoDAO.findBycodigo(Primeiro_Chamado.getCodigo());
        if (chamado == null) {
            setaTipoChamado(Primeiro_Chamado);
            setaAcoes(Primeiro_Chamado);
            Primeiro_Chamado.setPessoa(getPessoa());
            chamadoDAO.save(Primeiro_Chamado);
        } else {
            setaTipoChamado(chamado);
            setaAcoes(chamado);
            chamado.setPessoa(getPessoa());
            chamadoDAO.update(chamado);
        }
        chamado = chamadoDAO.findBycodigo(Primeiro_Chamado.getCodigo());
        Assert.assertNotNull(chamado);
    }

    private void setaTipoChamado(Chamado chamado) {
        if (tiposChamados == null || !tiposChamados.isEmpty()) {
            chamado.setTipoChamado(tiposChamados.get(0));
        }
    }

    private void setaAcoes(Chamado chamado) {
        if (chamado.getAcoes().isEmpty()) {
            Acao acaoUm = new Acao("Deletar banco de dados", chamado, getPessoa());
            Acao acaoDois = new Acao("Assassinar Usuário", chamado, getPessoa());
            acaoDois.setRaiz(acaoUm);
            acaoUm.getReacoes().add(acaoDois);
            chamado.getAcoes().add(acaoUm);
        }
    }

    private Pessoa getPessoa() {
        if (pessoas != null && !pessoas.isEmpty()) {
            return pessoas.get(0);
        }
        return null;
    }
}
