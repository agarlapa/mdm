/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.entity.Country;
import com.glycus.mdm.sessionbeans.CountryFacade;
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
@Path("country")
public class CountryResource {

    @Inject
    private CountryFacade dao;

    @GET
    public List<Country> findAll() {
        List<Country> countryList = dao.findAll();
        return countryList;
    }

    @GET
    @Path("findByCode")
    public Country findByCode(@Context HttpHeaders headers) {
        String code = headers.getRequestHeader("code").get(0);
        Country country = dao.findByCode(code);
        return country;
    }

    @POST
    public Response add(Country country) {
        dao.create(country);
        return Response.ok().build();
    }

    @PUT
    public Response update(Country country) {
        dao.edit(country);
        return Response.ok().build();
    }

}
