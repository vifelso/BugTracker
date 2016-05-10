package com.controller;


import com.dto.UserDto;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


@RunWith(MockitoJUnitRunner.class)
public class AdminNavigationTest {
    @Mock
    UserService userService;
    @InjectMocks
    AdminNavigation adminNavigation;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/webapp/pages/");
        viewResolver.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminNavigation).setViewResolvers(viewResolver).build();

    }

    @Test
    public void testAdminAccess() throws Exception {
        when(userService.getAllUsers()).thenReturn(getAllUsersDTos());
        this.mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin"))
                .andExpect(model().attribute("allUsers", hasSize(2)));
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