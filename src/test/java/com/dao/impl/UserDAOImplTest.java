package com.dao.impl;

import com.configs.HibernateTestConfig;
import com.dao.BugDAO;
import com.dao.RoleDAO;
import com.dao.UserDAO;
import com.model.Bug;
import com.model.Role;
import com.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Andrei on 09.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class UserDAOImplTest {

    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UserDAO userDAO;

    @Before
    public void init() {
        User user = new User();
        user.setLogin("Nick");
        user.setFirstname("Niki");
        user.setLastname("Visor");
        user.setEmail("nick@gmail.com");
        user.setPassword("111111");
        user.setRole(getRole());
        userDAO.addUser(user);
    }

    public Role getRole() {
        Role role = new Role();
        role.setRole("customer");
        roleDAO.addRole(role);
        return roleDAO.getRole(1);
    }

    @Test
    public void testGetUser() throws Exception {
        assertEquals("Niki", userDAO.getUser("Nick").getFirstname());

    }

    @Test
    public void testAddUser() throws Exception {
        checkAddUser();
        assertEquals("Axe", userDAO.getUser("moby").getLastname());

    }

    @Test
    public void testGetAllUsers() throws Exception {
        assertNotNull(userDAO.getAllUsers());

    }

    public void checkAddUser() {
        User user = new User();
        user.setLogin("moby");
        user.setFirstname("Garry");
        user.setLastname("Axe");
        user.setEmail("sally@gmail.com");
        user.setPassword("111111");
        user.setRole(getRole());
        userDAO.addUser(user);
    }

}