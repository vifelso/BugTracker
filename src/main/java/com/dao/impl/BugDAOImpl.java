package com.dao.impl;


import com.dao.AbstractDao;
import com.dao.BugDAO;
import com.model.Bug;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class BugDAOImpl extends AbstractDao<Integer, Bug> implements BugDAO {


    @Override
    public Bug getBug(int idBug) {

        return getByKey(idBug);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Bug> getAllBugs() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        List<Bug> list = criteria.list();
        return new HashSet<>(list);
    }

    @Override
    public void addBug(Bug bug) {
        persist(bug);
    }

    @Override
    public void editBug(Bug bug) {
        getSession().merge(bug);
    }
}
