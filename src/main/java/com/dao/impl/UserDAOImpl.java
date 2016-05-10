package com.dao.impl;

import com.dao.AbstractDao;
import com.dao.UserDAO;
import com.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl extends AbstractDao<Integer, User> implements UserDAO {


    @Override
    public User getUser(String login) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

    @Override
    public void addUser(User n) {
        persist(n);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<User> getAllUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        List<User> list = criteria.list();
        return new HashSet<>(list);
    }


}
