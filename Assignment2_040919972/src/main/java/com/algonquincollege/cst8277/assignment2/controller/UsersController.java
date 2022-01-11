/** 
 * @author Gloria omoba student 040-919-972
 * @date 2019 10 10
 * 
 */
package com.algonquincollege.cst8277.assignment2.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;

import com.algonquincollege.cst8277.assignment2.dao.UsersDAO;
import com.algonquincollege.cst8277.assignment2.model.User;

/**
 * Description- users controller class that interacts with JSF pages
 * 
 * @author omoba
 *
 */
@Named("usersEntityController")
@ApplicationScoped
public class UsersController implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    private UsersDAO usersDAO;

    private List<User> users;

    /**
     * 
     * @param usersDAO
     */
    @Inject
    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    /**
     * 
     * @param user- user to be created in database
     */
    public void createUser(User user) {
        usersDAO.createUser(user);
    }

    /**
     * load a user with the given Id
     * 
     * @param id - id to be updated
     * @return
     */
    public String loadUser(int id) {
        Entity e1 = (Entity) usersDAO.readUser(id);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("entity", e1);
        return "edit-user.";
    }

    /**
     * view a given user
     * 
     * @param user - user to be viewed
     */
    public User viewUser(int userId) {
        return usersDAO.readUser(userId);
    }

    /**
     * update a given user
     * 
     * @param user - user to be viewed
     */
    public void updateUser(User user) {
        usersDAO.updateUser(user);
    }

    /**
     * method to delete user from database
     * 
     * @param user to be deleted
     */
    public void deleteUser(User user) {
        usersDAO.deleteUser(user);
    }

    /**
     * call the set users method and sets the List of users
     */
    public void setUsersList() {
        this.setUsers(usersDAO.listAllUsers());

    }

    /**
     * 
     * @return the list of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * 
     * @param users - new values for the list of users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
