package com.service.impl;

import com.dao.RoleDAO;
import com.dto.RoleDto;
import com.mapper.RoleMapper;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public RoleDto getRole(int id) {
        return roleMapper.roleToroleDto(roleDAO.getRole(id));
    }

}
