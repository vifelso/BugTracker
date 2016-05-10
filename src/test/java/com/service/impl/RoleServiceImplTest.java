package com.service.impl;


import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dao.RoleDAO;
import com.dto.RoleDto;
import com.mapper.RoleMapper;
import com.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest {

    @Mock
    RoleDAO roleDAO;
    @Mock
    RoleMapper roleMapper;
    @InjectMocks
    RoleService roleService = new RoleServiceImpl();

    @Spy
    RoleDto roleDto = new RoleDto();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        roleDto = getRoleDto();
        roleMapper.roleToroleDto(roleDAO.getRole(anyInt()));
    }

    @Test
    public void testGetRole() throws Exception {
        when(roleMapper.roleToroleDto(roleDAO.getRole(anyInt()))).thenReturn(roleDto);
        verify(roleMapper).roleToroleDto(roleDAO.getRole(anyInt()));
        assertEquals(roleDto, roleService.getRole(roleDto.getId()));
    }

    public RoleDto getRoleDto() {
        RoleDto roleDto1 = new RoleDto();
        roleDto1.setId(4);
        roleDto1.setRole("admin");
        return roleDto1;
    }
}