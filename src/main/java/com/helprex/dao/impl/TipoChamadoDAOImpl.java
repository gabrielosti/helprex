package com.helprex.dao.impl;

import com.helprex.dao.GenericDAO;
import com.helprex.dao.TipoChamadoDAO;
import com.helprex.model.TipoChamado;
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
public class TipoChamadoDAOImpl extends GenericDAO<TipoChamado, Long> implements TipoChamadoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(TipoChamadoDAOImpl.class);

    public TipoChamadoDAOImpl() {
        super(TipoChamado.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<TipoChamado> findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("TipoChamado.findByNome", TipoChamado.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

}
