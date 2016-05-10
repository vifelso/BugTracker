package com.dao;

import com.model.Role;

public interface RoleDAO {

    Role getRole(int id);

    void addRole(Role role);

}
