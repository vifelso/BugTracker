package com.dao;

import com.model.User;

import java.util.Set;

public interface UserDAO {

    User getUser(String login);

    void addUser(User n);

    Set<User> getAllUsers();

}
