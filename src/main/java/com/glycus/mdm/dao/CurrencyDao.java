/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.dao;

import com.glycus.mdm.model.Currency;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author agarlapa
 */
public class CurrencyDao extends AbstractFacade<Currency> {

    @PersistenceContext(unitName = "MDM")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CurrencyDao() {
        super(Currency.class);
    }

    @Override
    public void create(Currency currency) {
        currency.setName(currency.getName());
        currency.setCode(currency.getCode());
        currency.setStatus("A");
        currency.setCreatedDateTime(new Date());
        getEntityManager().persist(currency);
    }

    @Override
    public void edit(Currency entity) {
        Currency currency = getEntityManager().find(Currency.class, entity.getId());
        currency.setId(entity.getId());
        currency.setName(entity.getName());
        currency.setCode(entity.getCode());
        currency.setStatus(entity.getStatus());
        currency.setCreatedDateTime(entity.getCreatedDateTime());
        currency.setModifiedDateTime(new Date());
        getEntityManager().merge(currency);
    }
    
    public Currency findByCode(String code) {
        Query query = getEntityManager().createQuery("select currency from Currency currency where currency.code = :code");
        query.setParameter("code", code);
        Currency currency = (Currency) query.getSingleResult();
        return currency;
    }
}
