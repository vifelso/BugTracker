
package com.mapper;

import com.dto.UserDto;
import com.model.User;

import java.util.Set;

public interface UserMapper {
    UserDto userDto(User user);

    User user(UserDto userDto);

    Set<UserDto> userDtos(Set<User> users);

    Set<User> users(Set<UserDto> userDtos);
}

