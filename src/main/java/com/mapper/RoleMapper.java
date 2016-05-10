package com.mapper;

import com.dto.RoleDto;
import com.model.Role;


public interface RoleMapper {
    Role roleDtoToRole(RoleDto roleDto);

    RoleDto roleToroleDto(Role role);
}
