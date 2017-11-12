/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.dao;

import com.glycus.mdm.model.User;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author agarlapa
 */
public class UserDao extends AbstractFacade<User> {

    @PersistenceContext(unitName = "MDM")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDao() {
        super(User.class);
    }

    @Override
    public void create(User user) {
        user.setName(user.getName());
        user.setCode(user.getCode());
        user.setEmailId(user.getEmailId());
        user.setPassword(user.getPassword());
        user.setIsBuyer(user.getIsBuyer());
        user.setAdditionalInfo(user.getAdditionalInfo());
        user.setStatus("A");
        user.setCreatedDateTime(new Date());
        getEntityManager().persist(user);
    }

    @Override
    public void edit(User entity) {
        User user = getEntityManager().find(User.class, entity.getId());
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setCode(entity.getCode());
        user.setEmailId(entity.getEmailId());
        user.setPassword(entity.getPassword());
        user.setIsBuyer(entity.getIsBuyer());
        user.setAdditionalInfo(entity.getAdditionalInfo());
        user.setStatus(entity.getStatus());
        user.setCreatedDateTime(entity.getCreatedDateTime());
        user.setModifiedDateTime(new Date());
        getEntityManager().merge(user);
    }

    public User findByCode(String code) {
        Query query = getEntityManager().createQuery("select user from User user where user.code = :code");
        query.setParameter("code", code);
        User user = (User) query.getSingleResult();
        return user;
    }
}
