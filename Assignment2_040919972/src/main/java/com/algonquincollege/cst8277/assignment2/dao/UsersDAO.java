/** 
 * @author Gloria omoba student 040-919-972
 * @date 2019 10 10
 * 
 */
package com.algonquincollege.cst8277.assignment2.dao;

import java.util.List;

import com.algonquincollege.cst8277.assignment2.model.User;

/**
 * This interface describes methods for CRUD operations on user entity
 * 
 * @author omoba
 *
 */
public interface UsersDAO {

    // C in CRUD
    User createUser(User user);

    // TODO – more methods required for CRUD (R, U, D)
    // R in CRUD
    User readUser(int userId);

    // U in CRUD
    void updateUser(User user);

    // D in CRUD
    void deleteUser(User user);

    // list all users
    List<User> listAllUsers();
}
