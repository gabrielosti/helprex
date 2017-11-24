/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.service.impl;

import com.helprex.dao.DAO;
import com.helprex.dao.TipoChamadoDAO;
import com.helprex.model.TipoChamado;
import com.helprex.service.GenericCRUDRestService;
import com.helprex.service.TipoChamadoService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gabriel
 */
@ManagedBean
@Path("/tipochamado")
public class TipoChamadoServiceImpl extends GenericCRUDRestService<TipoChamado> implements TipoChamadoService {

    private static final Logger LOG = LoggerFactory.getLogger(TipoChamadoServiceImpl.class);

    @Inject
    private TipoChamadoDAO tipoChamadoDAO;

    public TipoChamadoServiceImpl() {
        super(TipoChamado.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<TipoChamado> list) {
        return new GenericEntity<List<TipoChamado>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return tipoChamadoDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
