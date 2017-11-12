/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.dao;

import com.glycus.mdm.model.Gender;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author agarlapa
 */
public class GenderDao extends AbstractFacade<Gender> {

    @PersistenceContext(unitName = "MDM")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenderDao() {
        super(Gender.class);
    }
    
    @Override
    public void create(Gender gender) {
        gender.setName(gender.getName());
        gender.setStatus("A");
        gender.setCreatedDateTime(new Date());
        getEntityManager().persist(gender);
    }

    @Override
    public void edit(Gender entity) {
        Gender gender = getEntityManager().find(Gender.class, entity.getId());
        gender.setId(entity.getId());
        gender.setName(entity.getName());
        gender.setStatus(entity.getStatus());
        gender.setCreatedDateTime(entity.getCreatedDateTime());
        gender.setModifiedDateTime(new Date());
        getEntityManager().merge(gender);
    }
    
    public Gender findByName(String name) {
        Query query = getEntityManager().createQuery("select gender from Gender gender where gender.name = :name");
        query.setParameter("name", name);
        Gender gender = (Gender) query.getSingleResult();
        return gender;
    }
}
