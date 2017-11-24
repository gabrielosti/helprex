package com.helprex.dao;

import com.helprex.dao.impl.PessoaDAOImpl;
import com.helprex.model.Pessoa;
import java.util.List;
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
@AdditionalClasses({PessoaDAOImpl.class})
public class PessoaTest {

    private static final Pessoa DE_OSTI;

    @Inject
    private PessoaDAO pessoaDAO;

    static {
        DE_OSTI = new Pessoa("Gabriel De Osti", "999.999.999-00");
    }

    @Test
    public void injectionTest() {
        Assert.assertNotNull(pessoaDAO);
    }

    @Test
    public void saveTest() {
        List<Pessoa> pessoas = pessoaDAO.findByNome(DE_OSTI.getNome());
        if (pessoas == null || pessoas.isEmpty()) {
            pessoaDAO.save(DE_OSTI);
            pessoas = pessoaDAO.findByNome(DE_OSTI.getNome());
        }
        Assert.assertNotNull(pessoas);
    }
}
