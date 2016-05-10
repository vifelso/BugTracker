package com.dao;


import com.model.Bug;

import java.util.Set;


public interface BugDAO {
    Bug getBug(int id);

    Set getAllBugs();

    void addBug(Bug bug);

    void editBug(Bug bug);
}
