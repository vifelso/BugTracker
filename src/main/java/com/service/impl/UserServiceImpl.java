package com.service.impl;

import com.dao.UserDAO;
import com.dto.UserDto;
import com.mapper.UserMapper;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDto getUser(String login) {
        return userMapper.userDto(userDAO.getUser(login));
    }

    @Override
    public void addUser(UserDto n) {
        userDAO.addUser(userMapper.user(n));
        log.debug("save user with login:=" + n.getLogin() + " and password:=" + n.getPassword());
    }

    @Override
    public UserDetails getCurrentUser() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public Set<UserDto> getAllUsers() {
        return userMapper.userDtos(userDAO.getAllUsers());
    }
}
