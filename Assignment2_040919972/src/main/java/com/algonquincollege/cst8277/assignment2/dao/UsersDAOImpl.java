/** 
 * @author Gloria omoba student 040-919-972
 * @date 2019 10 10
 * 
 */
package com.algonquincollege.cst8277.assignment2.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import com.algonquincollege.cst8277.assignment2.ejb.UsersEJB;
import com.algonquincollege.cst8277.assignment2.model.User;

/**
 * Description - This class implements the UsersDAO and serializable interfaces
 * 
 * @author omoba
 *
 */
@Named
@ApplicationScoped
public class UsersDAOImpl implements Serializable, UsersDAO {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    @EJB
    private UsersEJB usersEJB;

    /**
     * create a new user
     * 
     * @param user - user to be created
     * @return new user object
     */
    @Override
    public User createUser(User user) {
        return usersEJB.createUser(user);
    }

    /**
     * read user using user Id
     * 
     * @param user - entity to be read
     * @return user object
     */
    @Override
    public User readUser(int userId) {
        return usersEJB.readUser(userId);
    }

    /**
     * update a user
     * 
     * @param user - entity to be updated
     * 
     */
    @Override
    public void updateUser(User user) {
        usersEJB.updateUser(user);

    }

    /**
     * 
     * @param user - entity to be deleted
     */
    @Override
    public void deleteUser(User user) {
        usersEJB.deleteUser(user);

    }

    /**
     * 
     * @return list of all users
     */
    @Override
    public List<User> listAllUsers() {
        return usersEJB.listAllUsers();

    }

}