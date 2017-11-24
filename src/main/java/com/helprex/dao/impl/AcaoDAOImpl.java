/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao.impl;

import com.helprex.dao.AcaoDAO;
import com.helprex.dao.GenericDAO;
import com.helprex.model.Acao;
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
public class AcaoDAOImpl extends GenericDAO<Acao, Long> implements AcaoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(AcaoDAOImpl.class);
    
    public AcaoDAOImpl(Class<Acao> entityClass) {
        super(entityClass);
    }
  
    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Acao findBytexto(String texto) {
        Query query = getEntityManager().createNamedQuery("Acao.findBycodigo", Acao.class);
        query.setParameter("texto", texto);
        
        List<Acao> Acoes = query.getResultList();
        if (Acoes == null || Acoes.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return Acoes.get(0);
        }
    }
    
}
