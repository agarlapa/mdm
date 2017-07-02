/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.sessionbeans;

import com.glycus.mdm.entity.UOM;
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
public class UOMFacade extends AbstractFacade<UOM> {

    @PersistenceContext(unitName = "MDM")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UOMFacade() {
        super(UOM.class);
    }

    @Override
    public void create(UOM uom) {
        uom.setName(uom.getName());
        uom.setCode(uom.getCode());
        uom.setAdditionalInfo(uom.getAdditionalInfo());
        uom.setStatus("A");
        uom.setCreatedDateTime(new Date());
        getEntityManager().persist(uom);
    }

    @Override
    public void edit(UOM entity) {
        UOM uom = getEntityManager().find(UOM.class, entity.getId());
        uom.setId(entity.getId());
        uom.setName(entity.getName());
        uom.setCode(entity.getCode());
        uom.setAdditionalInfo(entity.getAdditionalInfo());
        uom.setStatus(entity.getStatus());
        uom.setCreatedDateTime(entity.getCreatedDateTime());
        uom.setModifiedDateTime(new Date());
        getEntityManager().merge(uom);
    }

    public UOM findByCode(String code) {
        Query query = getEntityManager().createQuery("select uom from UOM uom where uom.code = :code");
        query.setParameter("code", code);
        UOM uom = (UOM) query.getSingleResult();
        return uom;
    }

}
