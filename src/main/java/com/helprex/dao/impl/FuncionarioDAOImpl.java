/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao.impl;

import com.helprex.dao.FuncionarioDAO;
import com.helprex.dao.GenericDAO;
import com.helprex.model.Funcionario;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gabriel
 */
@ApplicationScoped
public class FuncionarioDAOImpl extends GenericDAO<Funcionario, Long> implements FuncionarioDAO {

    private static final Logger LOG = LoggerFactory.getLogger(FuncionarioDAOImpl.class);

    public FuncionarioDAOImpl() {
        super(Funcionario.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Funcionario findBycodigoInterno(String codigoInterno) {
        Query query = getEntityManager().createNamedQuery("Funcionario.findBycodigoInterno", Funcionario.class);
        query.setParameter("codigoInterno", codigoInterno);

        List<Funcionario> funcionarios = query.getResultList();
        if (funcionarios == null || funcionarios.isEmpty()) {
            return null;
        } else if (funcionarios.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return funcionarios.get(0);
        }
    }

    @Override
    public List<Funcionario> findBytiposChamado(String tiposChamado) {
        Query query = getEntityManager().createNamedQuery("Funcionario.findBycodigoInterno", Funcionario.class);
        query.setParameter("codigoInterno", tiposChamado + "%");
        return query.getResultList();
    }

}
