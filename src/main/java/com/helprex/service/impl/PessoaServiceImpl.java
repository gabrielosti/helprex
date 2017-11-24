package com.helprex.service.impl;

import com.helprex.dao.DAO;
import com.helprex.dao.PessoaDAO;
import com.helprex.model.Pessoa;
import com.helprex.service.GenericCRUDRestService;
import com.helprex.service.PessoaService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gabriel
 */
@ManagedBean
 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("/pessoa")
public class PessoaServiceImpl extends GenericCRUDRestService<Pessoa> implements PessoaService {

    private static final Logger LOG = LoggerFactory.getLogger(PessoaServiceImpl.class);

    @Inject
    private PessoaDAO pessoaDAO;

    public PessoaServiceImpl() {
        super(Pessoa.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Pessoa> list) {
        return new GenericEntity<List<Pessoa>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return pessoaDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
