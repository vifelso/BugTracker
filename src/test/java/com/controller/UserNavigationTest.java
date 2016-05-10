package com.controller;


import com.dto.UserDto;
import com.service.RoleService;
import com.service.UserService;
import com.validation.UserDtoValidation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(MockitoJUnitRunner.class)

public class UserNavigationTest {
    @Mock
    UserService userService;
    @Mock
    UserDtoValidation userDtoValidation;
    @Mock
    RoleService roleService;
    @Mock
    BindingResult result;
    @InjectMocks
    UserNavigation userNavigation;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/webapp/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders
                .standaloneSetup(userNavigation)
                .setValidator(userDtoValidation)
                .setViewResolvers(viewResolver)
                .build();
        when(userDtoValidation.supports(any(Class.class))).thenReturn(true);

    }

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/index")).andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    public void testAddUser() throws Exception {
        when(userService.getUser(anyString())).thenReturn(getUserDto());
        mockMvc.perform(post("/doneRegistration")).andExpect(status().isOk())
                .andExpect(view().name("register"));
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