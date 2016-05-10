package com.dao.impl;

import com.dao.AbstractDao;
import com.dao.RoleDAO;
import com.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends AbstractDao<Integer, Role> implements RoleDAO {


    @Override
    public Role getRole(int id) {

        return getByKey(id);
    }

    @Override
    public void addRole(Role role) {
        persist(role);
    }


}
