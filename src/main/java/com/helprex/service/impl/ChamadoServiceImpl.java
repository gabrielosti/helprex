/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.service.impl;

import com.helprex.dao.ChamadoDAO;
import com.helprex.dao.DAO;
import com.helprex.model.Chamado;
import com.helprex.service.ChamadoService;
import com.helprex.service.GenericCRUDRestService;
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
@Path("/chamado")
public class ChamadoServiceImpl extends GenericCRUDRestService<Chamado> implements ChamadoService{

    private static final Logger LOG = LoggerFactory.getLogger(ChamadoServiceImpl.class);
    
    @Inject
    private ChamadoDAO chamadoDAO;
    
    public ChamadoServiceImpl() {
        super(Chamado.class);
    }
    
    @Override
    public GenericEntity listToGenericEntity(List<Chamado> list) {
        return new GenericEntity<List<Chamado>>(list){};
    }

  @Override
    public DAO getDao() {
        return chamadoDAO;
    }
    
    @Override
    public Logger getLogger() {
        return LOG;
    }

  
}
