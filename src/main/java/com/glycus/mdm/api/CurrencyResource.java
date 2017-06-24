/**
 *
 */
package com.glycus.mdm.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.glycus.mdm.entity.Currency;
import com.glycus.mdm.sessionbeans.CurrencyFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author agarlapa
 *
 */
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("currency")
public class CurrencyResource {

    @Inject
    private CurrencyFacade dao;

    @GET
    public List<Currency> findAll() {
        List<Currency> currencyList = dao.findAll();
        return currencyList;
    }

    @GET
    @Path("findByCode")
    public Currency findByCode(@Context HttpHeaders headers) {
        String code = headers.getRequestHeader("code").get(0);
        Currency currency = dao.findByCode(code);
        return currency;
    }

    @POST
    public Response add(Currency currency) {
        dao.create(currency);
        return Response.ok().build();
    }

    @PUT
    public Response update(Currency currency) {
        dao.edit(currency);
        return Response.ok().build();
    }
}
