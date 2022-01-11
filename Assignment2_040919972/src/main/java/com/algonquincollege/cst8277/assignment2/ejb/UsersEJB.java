/** 
 * @author Gloria omoba student 040-919-972
 * @date 2019 10 10
 * 
 */
package com.algonquincollege.cst8277.assignment2.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import com.algonquincollege.cst8277.assignment2.model.User;

/**
 * Description -  This class is the users entity java bean class
 * @author omoba
 *
 */
@Stateless
public class UsersEJB{

    @PersistenceContext(unitName = "assignment2-PU")
    protected EntityManager em;

    /**
     * Default constructor
     */
    public UsersEJB() {
    }

    /**
     * create a new user
     * @param user - user to be created
     * @return new user object
     */
    @Transactional
    public User createUser(User user) { 
        em.persist(user);
        return user;
    }

    /**
     * get user using user Id
     * 
     * @param user - entity to be read
     * @return user object
     */
    @Transactional
    public User readUser(int userId) {
        return em.find(User.class, userId);
    }

    /**
     * update a user
     * 
     * @param user - entity to be updated
     * 
     */
    public User updateUser(User user) {
        return em.merge(user);
    }

    /**
     * 
     * @param user - entity to be deleted
     */
    public void deleteUser(User user) {
        em.remove(em.merge(user));
        //em.createQuery(qlString)
    }

    /**
     * get all rows of this table using CriteriaQuery
     * @return list of all rows
     */
    public List<User> listAllUsers() {
        // using the builder create a CriteriaQuery of type entityClass
        CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
        // select everything from entityClass
        cq.select(cq.<User>from(User.class));
        // create the query based on CriteriaQuery, execute and return the results
        return em.<User>createQuery(cq).getResultList();

    }

}
