package com.dto;


import java.util.Set;

public class UserDto {
    private int id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private RoleDto role;
    private Set<BugDto> bugs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public Set<BugDto> getBugs() {
        return bugs;
    }

    public void setBugs(Set<BugDto> bugs) {
        this.bugs = bugs;
    }
}
