package com.springboot.blogproject.Service;

import com.springboot.blogproject.Payload.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> getAllUser(UserDto userDto);

    UserDto getUserbyId(int id);

    UserDto updateUser(UserDto userDto,int id);

    String createUser(UserDto userDto);

    void deleteUser(int id);
    List<UserDto>searchByName(String name);


}
