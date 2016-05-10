package com.dto;

import java.util.Set;


public class RoleDto {
    private int id;
    private String role;
    private Set<UserDto> getUserRolesDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserDto> getUserRolesDto() {
        return getUserRolesDto;
    }

    public void setUserRolesDto(Set<UserDto> userRolesDto) {
        this.getUserRolesDto = getUserRolesDto();
    }
}
