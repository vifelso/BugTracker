package com.mapper.impl;

import com.dto.RoleDto;
import com.mapper.RoleMapper;
import com.model.Role;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RoleMapperImpl implements RoleMapper {
    @Autowired
    private MapperFacade mapper;

    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        return mapper.map(roleDto, Role.class);
    }

    @Override
    public RoleDto roleToroleDto(Role role) {
        return mapper.map(role, RoleDto.class);
    }
}
