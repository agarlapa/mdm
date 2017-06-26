/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.entity.PaymentMethod;
import com.glycus.mdm.sessionbeans.PaymentMethodFacade;
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
@Path("paymentMethod")
public class PaymentMethodResource {
    @Inject
    private PaymentMethodFacade dao;

    @GET
    public List<PaymentMethod> findAll() {
        List<PaymentMethod> paymentMethodList = dao.findAll();
        return paymentMethodList;
    }

    @GET
    @Path("findByCode")
    public PaymentMethod findByCode(@Context HttpHeaders headers) {
        String code = headers.getRequestHeader("code").get(0);
        PaymentMethod paymentMethod = dao.findByCode(code);
        return paymentMethod;
    }

    @POST
    public Response add(PaymentMethod paymentMethod) {
        dao.create(paymentMethod);
        return Response.ok().build();
    }

    @PUT
    public Response update(PaymentMethod paymentMethod) {
        dao.edit(paymentMethod);
        return Response.ok().build();
    }

}
