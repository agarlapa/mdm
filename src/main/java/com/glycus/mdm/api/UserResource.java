/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.entity.User;
import com.glycus.mdm.sessionbeans.UserFacade;
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
@Path("user")
public class UserResource {

    @Inject
    private UserFacade dao;

    @GET
    public List<User> findAll() {
        List<User> userList = dao.findAll();
        return userList;
    }

    @GET
    @Path("findByCode")
    public User findByCode(@Context HttpHeaders headers) {
        String code = headers.getRequestHeader("code").get(0);
        User user = dao.findByCode(code);
        return user;
    }

    @POST
    public Response add(User user) {
        dao.create(user);
        return Response.ok().build();
    }

    @PUT
    public Response update(User user) {
        dao.edit(user);
        return Response.ok().build();
    }

}
