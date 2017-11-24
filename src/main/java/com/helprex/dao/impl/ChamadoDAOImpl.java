/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.dao.impl;

import com.helprex.dao.ChamadoDAO;
import com.helprex.dao.GenericDAO;
import com.helprex.model.Chamado;
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
public class ChamadoDAOImpl extends GenericDAO<Chamado, Long> implements ChamadoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ChamadoDAOImpl.class);

    public ChamadoDAOImpl() {
        super(Chamado.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Chamado findBycodigo(String codigo) {
        Query query = getEntityManager().createNamedQuery("Chamado.findBycodigo", Chamado.class);
        query.setParameter("codigo", codigo);

        List<Chamado> chamados = query.getResultList();
        if (chamados == null || chamados.isEmpty()) {
            return null;
        } else if(chamados.size() > 1){
            throw new NonUniqueResultException();
        } else {
            return chamados.get(0);
        }
    }

    @Override
    public Chamado findBytitulo(String titulo) {
        Query query = getEntityManager().createNamedQuery("Chamado.findBycodigoInterno", Chamado.class);
        query.setParameter("titulo", titulo);

        List<Chamado> Chamados = query.getResultList();
        if (Chamados == null || Chamados.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return Chamados.get(0);
        }
    }

}
