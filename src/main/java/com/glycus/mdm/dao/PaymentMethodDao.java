/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.dao;

import com.glycus.mdm.model.PaymentMethod;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author agarlapa
 */
public class PaymentMethodDao extends AbstractFacade<PaymentMethod> {

    @PersistenceContext(unitName = "MDM")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentMethodDao() {
        super(PaymentMethod.class);
    }
    
    @Override
    public void create(PaymentMethod paymentMethod) {
        paymentMethod.setName(paymentMethod.getName());
        paymentMethod.setCode(paymentMethod.getCode());
        paymentMethod.setAdditionalInfo(paymentMethod.getAdditionalInfo());
        paymentMethod.setStatus("A");
        paymentMethod.setCreatedDateTime(new Date());
        getEntityManager().persist(paymentMethod);
    }

    @Override
    public void edit(PaymentMethod entity) {
        PaymentMethod paymentMethod = getEntityManager().find(PaymentMethod.class, entity.getId());
        paymentMethod.setId(entity.getId());
        paymentMethod.setName(entity.getName());
        paymentMethod.setCode(entity.getCode());
        paymentMethod.setAdditionalInfo(entity.getAdditionalInfo());
        paymentMethod.setStatus(entity.getStatus());
        paymentMethod.setCreatedDateTime(entity.getCreatedDateTime());
        paymentMethod.setModifiedDateTime(new Date());
        getEntityManager().merge(paymentMethod);
    }

    public PaymentMethod findByCode(String code) {
        Query query = getEntityManager().createQuery("select paymentMethod from PaymentMethod paymentMethod where paymentMethod.code = :code");
        query.setParameter("code", code);
        PaymentMethod paymentMethod = (PaymentMethod) query.getSingleResult();
        return paymentMethod;
    }
}
