/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.entity.UOM;
import com.glycus.mdm.sessionbeans.UOMFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author agarlapa
 */
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("uom")
public class UOMResource {
     @Inject
    private UOMFacade dao;

    @GET
    public List<UOM> findAll() {
        List<UOM> uomList = dao.findAll();
        return uomList;
    }

    @GET
    @Path("findByCode")
    public UOM findByCode(@Context HttpHeaders headers) {
        String code = headers.getRequestHeader("code").get(0);
        UOM uom = dao.findByCode(code);
        return uom;
    }

    @POST
    public Response add(UOM uom) {
        dao.create(uom);
        return Response.ok().build();
    }

    @PUT
    public Response update(UOM uom) {
        dao.edit(uom);
        return Response.ok().build();
    }

    
}
