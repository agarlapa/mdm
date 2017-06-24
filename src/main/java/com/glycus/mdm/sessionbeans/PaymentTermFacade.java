/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.sessionbeans;

import com.glycus.mdm.entity.PaymentTerm;
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
public class PaymentTermFacade extends AbstractFacade<PaymentTerm> {

    @PersistenceContext(unitName = "MDM")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentTermFacade() {
        super(PaymentTerm.class);
    }

    @Override
    public void create(PaymentTerm paymentTerm) {
        paymentTerm.setName(paymentTerm.getName());
        paymentTerm.setCode(paymentTerm.getCode());
        paymentTerm.setAdditionalInfo(paymentTerm.getAdditionalInfo());
        paymentTerm.setStatus("A");
        paymentTerm.setCreatedDateTime(new Date());
        getEntityManager().persist(paymentTerm);
    }

    @Override
    public void edit(PaymentTerm entity) {
        PaymentTerm paymentTerm = getEntityManager().find(PaymentTerm.class, entity.getId());
        paymentTerm.setId(entity.getId());
        paymentTerm.setName(entity.getName());
        paymentTerm.setCode(entity.getCode());
        paymentTerm.setAdditionalInfo(paymentTerm.getAdditionalInfo());
        paymentTerm.setStatus(entity.getStatus());
        paymentTerm.setCreatedDateTime(entity.getCreatedDateTime());
        paymentTerm.setModifiedDateTime(new Date());
        getEntityManager().merge(paymentTerm);
    }

    public PaymentTerm findByCode(String code) {
        Query query = getEntityManager().createQuery("select paymentTerm from PaymentTerm paymentTerm where paymentTerm.code = :code");
        query.setParameter("code", code);
        PaymentTerm paymentTerm = (PaymentTerm) query.getSingleResult();
        return paymentTerm;
    }
}
