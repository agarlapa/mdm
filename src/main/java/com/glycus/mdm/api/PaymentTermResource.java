/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.entity.PaymentTerm;
import com.glycus.mdm.sessionbeans.PaymentTermFacade;
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
@Path("paymentterm")
public class PaymentTermResource {
    
     @Inject
    private PaymentTermFacade dao;

    @GET
    public List<PaymentTerm> findAll() {
        List<PaymentTerm> paymentTermList = dao.findAll();
        return paymentTermList;
    }

    @GET
    @Path("findByCode")
    public PaymentTerm findByCode(@Context HttpHeaders headers) {
        String code = headers.getRequestHeader("code").get(0);
        PaymentTerm paymentTerm = dao.findByCode(code);
        return paymentTerm;
    }

    @POST
    public Response add(PaymentTerm paymentTerm) {
        dao.create(paymentTerm);
        return Response.ok().build();
    }

    @PUT
    public Response update(PaymentTerm paymentTerm) {
        dao.edit(paymentTerm);
        return Response.ok().build();
    }
    
}
