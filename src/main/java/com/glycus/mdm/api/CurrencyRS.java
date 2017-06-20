/**
 *
 */
package com.glycus.mdm.api;

import com.glycus.mdm.dto.Currencies;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.glycus.mdm.entity.Currency;
import com.glycus.mdm.sessionbeans.CurrencyFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author agarlapa
 *
 */
@Path("currency")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CurrencyRS {

    @Inject
    private CurrencyFacade dao;

    @GET
    @Path("findByCode")
    public Currencies findByCode(@Context HttpHeaders headers) {
        String code = headers.getRequestHeader("code").get(0);
        List<Currency> currencyList = dao.findAll();
        Currencies currencies = new Currencies();
        currencies.setCurrency(currencyList);
        return currencies;
    }

    @POST
    @Path("create")
    public Response create(Currency currencyDto) {
        System.out.println("Here  ");
        com.glycus.mdm.entity.Currency entity = mapDtoToEntity(currencyDto);
        dao.create(entity);
        return Response.ok().build();
    }

    private com.glycus.mdm.entity.Currency mapDtoToEntity(Currency currency) {
        com.glycus.mdm.entity.Currency currencyEntity = new com.glycus.mdm.entity.Currency();
        currencyEntity.setName(currency.getName());
        currencyEntity.setCode(currency.getCode());
        currencyEntity.setStatus(currency.getStatus());
        currencyEntity.setCreatedDateTime(currency.getCreatedDateTime());
        currencyEntity.setModifiedDateTime(currency.getModifiedDateTime());
        return currencyEntity;
    }
}
