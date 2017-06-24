/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.entity.Gender;
import com.glycus.mdm.sessionbeans.GenderFacade;
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
@Path("gender")

public class GenderResource {
    
    @Inject
    private GenderFacade dao;

    @GET
    public List<Gender> findAll() {
        List<Gender> listOfGenders = dao.findAll();
        return listOfGenders;
    }

    @GET
    @Path("findByName")
    public Gender findByCode(@Context HttpHeaders headers) {
        String name = headers.getRequestHeader("name").get(0);
        Gender gender = dao.findByName(name);
        return gender;
    }

    @POST
    public Response add(Gender gender) {
        dao.create(gender);
        return Response.ok().build();
    }

    @PUT
    public Response update(Gender gender) {
        dao.edit(gender);
        return Response.ok().build();
    }
}
