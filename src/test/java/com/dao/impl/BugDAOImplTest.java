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

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class BugDAOImplTest {

    @Autowired
    private BugDAO bugDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UserDAO userDAO;

    @Before
    public void init() {
        Bug bug = new Bug();
        bug.setAutor("Mary");
        bug.setStatus("open");
        bug.setDate(new Date());
        bug.setTitle("tit");
        bug.setDesc("desc1");
        bug.setPrior("important");
        bug.setUser(getUser());
        bugDAO.addBug(bug);
        bugDAO.getBug(1);
    }

    public User getUser() {
        User user = new User();
        user.setLogin("Mary");
        user.setFirstname("Maria");
        user.setLastname("Fox");
        user.setEmail("mary@gmail.com");
        user.setPassword("111111");
        user.setRole(getRole());
        userDAO.addUser(user);
        return userDAO.getUser("Mary");
    }

    public Role getRole() {
        Role role = new Role();
        role.setRole("customer");
        roleDAO.addRole(role);
        return roleDAO.getRole(1);
    }


    @Test
    public void testGetBug() throws Exception {
        assertEquals("Mary", bugDAO.getBug(1).getAutor());

    }

    @Test
    public void testGetAllBugs() throws Exception {
        assertNotNull(bugDAO.getAllBugs());
    }

    @Test
    public void testAddBug() throws Exception {
        checkAddBug();
        assertEquals("miki", bugDAO.getBug(2).getAutor());

    }

    @Test
    public void testEditBug() throws Exception {
        Bug bug = bugDAO.getBug(1);
        bug.setTitle("editBug");
        bugDAO.editBug(bug);
        assertEquals("editBug", bugDAO.getBug(1).getTitle());

    }

    public Bug checkAddBug() {
        Bug bug = new Bug();
        bug.setAutor("miki");
        bug.setStatus("open");
        bug.setDate(new Date());
        bug.setTitle("tit");
        bug.setDesc("desc1");
        bug.setPrior("important");
        bug.setUser(getUser1());
        bugDAO.addBug(bug);
        return bugDAO.getBug(2);
    }

    public User getUser1() {
        User user = new User();
        user.setLogin("miki");
        user.setFirstname("Joseph");
        user.setLastname("Baldor");
        user.setEmail("joseph@gmail.com");
        user.setPassword("111111");
        user.setRole(getRole1());
        userDAO.addUser(user);
        return userDAO.getUser("miki");
    }

    public Role getRole1() {
        Role role = new Role();
        role.setRole("admin");
        roleDAO.addRole(role);
        return roleDAO.getRole(2);
    }

}