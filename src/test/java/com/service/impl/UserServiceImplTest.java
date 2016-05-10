package com.service.impl;

import com.dao.UserDAO;
import com.dto.UserDto;
import com.mapper.UserMapper;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Andrei on 09.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Mock
    UserDAO userDAO;
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserService userService = new UserServiceImpl();
    @Spy
    Set<UserDto> userDtos = new HashSet<>();
    @Spy
    UserDto userDto = new UserDto();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userDto = getUserDto();
        userDtos = getAllUsersDTos();
        userMapper.userDto(userDAO.getUser("Johni"));
        userMapper.userDtos(userDAO.getAllUsers());
    }

    @Test
    public void testGetUser() throws Exception {
        when(userMapper.userDto(userDAO.getUser("Johni"))).thenReturn(userDto);
        assertEquals(userDto, userService.getUser(userDto.getLogin()));

    }

    @Test
    public void testGetAllUsers() throws Exception {
        when(userMapper.userDtos(userDAO.getAllUsers())).thenReturn(userDtos);
        assertEquals(false, userService.getAllUsers().isEmpty());
    }

    public Set<UserDto> getAllUsersDTos() {
        Set<UserDto> userDtos = new HashSet<>();
        userDtos.add(getUserDto());
        userDtos.add(getUserDto());
        return userDtos;
    }

    public UserDto getUserDto() {
        UserDto userDto1 = new UserDto();
        userDto1.setLogin("maximus");
        userDto1.setPassword("111111");
        userDto1.setFirstname("Johni");
        userDto1.setLastname("Srtaid");
        userDto1.setEmail("johni@gmail.com");
        return userDto1;
    }

}