/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.sessionbeans;

import com.glycus.mdm.entity.Country;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author agarlapa
 */
@Stateless
public class CountryFacade extends AbstractFacade<Country> {

    @PersistenceContext(unitName = "MDM")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryFacade() {
        super(Country.class);
    }
    
    @Override
    public void create(Country country) {
        country.setName(country.getName());
        country.setCode(country.getCode());
        country.setPhoneCode(country.getPhoneCode());
        country.setStatus("A");
        country.setCreatedDateTime(new Date());
        getEntityManager().persist(country);
    }

    @Override
    public void edit(Country entity) {
        Country country = getEntityManager().find(Country.class, entity.getId());
        country.setId(entity.getId());
        country.setName(entity.getName());
        country.setCode(entity.getCode());
        country.setPhoneCode(entity.getPhoneCode());
        country.setStatus(entity.getStatus());
        country.setCreatedDateTime(entity.getCreatedDateTime());
        country.setModifiedDateTime(new Date());
        getEntityManager().merge(country);
    }
    
    public Country findByCode(String code) {
        Query query = getEntityManager().createQuery("select country from Country country where country.code = :code");
        query.setParameter("code", code);
        Country country = (Country) query.getSingleResult();
        return country;
    }
    
}
