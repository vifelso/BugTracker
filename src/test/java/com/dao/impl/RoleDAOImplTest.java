package com.dao.impl;

import com.configs.HibernateTestConfig;
import com.dao.RoleDAO;
import com.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Andrei on 09.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class RoleDAOImplTest {

    @Autowired
    private RoleDAO roleDAO;

    @Before
    public void init() {
        Role role = new Role();
        role.setRole("admin");
        roleDAO.addRole(role);
        Role role1 = new Role();
        role1.setRole("user");
        roleDAO.addRole(role1);

    }

    @Test
    public void testGetRole() throws Exception {
        assertEquals(roleDAO.getRole(1).getRole(), "admin");
    }

    @Test
    public void testAddRole() throws Exception {
        Role role2 = new Role();
        role2.setRole("moderator");
        roleDAO.addRole(role2);
        assertEquals(roleDAO.getRole(3).getRole(), "moderator");
    }
}