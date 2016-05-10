package com.service;

import com.dto.UserDto;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public interface UserService {

    UserDto getUser(String login);

    void addUser(UserDto n);

    UserDetails getCurrentUser() throws NotFoundException;

    Set<UserDto> getAllUsers();


}
