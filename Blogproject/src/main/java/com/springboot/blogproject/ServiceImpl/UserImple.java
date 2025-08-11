package com.springboot.blogproject.ServiceImpl;

import com.springboot.blogproject.Entities.User;
import com.springboot.blogproject.Exception.UserNotFoundException;
import com.springboot.blogproject.Payload.UserDto;
import com.springboot.blogproject.Repository.UserRepo;
import com.springboot.blogproject.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImple implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
 @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public List<UserDto> getAllUser(UserDto userDto) {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map((userValue) -> modelMapper.
                map(userValue, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override

    public UserDto getUserbyId(int id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user", "User Not Found", id));
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user", "User Not Found", id));
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        userRepo.save(user);
        userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public String createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);
        return "User Created Succesfully";
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user", "User Not Found", id));
        userRepo.delete(user);
    }

    @Override
    public List<UserDto> searchByName(String name) {
        List<User>users = userRepo.findByNameContaining(name);
        List<UserDto>userDtos=users.stream().map(user ->
                modelMapper.map(user,UserDto.class)).collect(Collectors.toList());

        return userDtos;
    }
}
