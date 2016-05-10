package com.mapper.impl;

import com.dto.UserDto;
import com.mapper.UserMapper;
import com.model.User;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class UserMapperImpl implements UserMapper {
    @Autowired
    private MapperFacade mapper;

    @Override
    public UserDto userDto(User user) {
        return mapper.map(user, UserDto.class);
    }

    @Override
    public User user(UserDto userDto) {
        return mapper.map(userDto, User.class);
    }

    @Override
    public Set<UserDto> userDtos(Set<User> users) {
        if (users == null) {
            return null;
        }

        return users.stream().map(this::userDto).collect(Collectors.toSet());
    }

    @Override
    public Set<User> users(Set<UserDto> userDtos) {

        if (userDtos == null) {
            return null;
        }

        return userDtos.stream().map(this::user).collect(Collectors.toSet());
    }
}
