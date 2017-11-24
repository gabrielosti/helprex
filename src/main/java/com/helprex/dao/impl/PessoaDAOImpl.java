/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao.impl;

import com.helprex.dao.GenericDAO;
import com.helprex.dao.PessoaDAO;
import com.helprex.model.Pessoa;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gabriel
 */
@ApplicationScoped
public class PessoaDAOImpl extends GenericDAO<Pessoa, Long> implements PessoaDAO {

    private static final Logger LOG = LoggerFactory.getLogger(PessoaDAOImpl.class);

    public PessoaDAOImpl() {
        super(Pessoa.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Pessoa.findByNome", Pessoa.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

    @Override
    public List<Pessoa> findByCpfCnpj(String cpfcnpj) {
        Query query = getEntityManager().createNamedQuery("Pessoa.findByCpfCnpj", Pessoa.class);
        query.setParameter("cpfcnpj", cpfcnpj + "%");
        return query.getResultList();
    }

}
