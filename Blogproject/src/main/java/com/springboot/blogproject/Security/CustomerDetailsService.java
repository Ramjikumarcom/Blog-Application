package com.springboot.blogproject.Security;

import com.springboot.blogproject.Entities.User;
import com.springboot.blogproject.Exception.UserNotFoundException;
import com.springboot.blogproject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from database by username
    User user=userRepo.findByEmail(username).orElseThrow(()->new UserNotFoundException("user","email"+username,0));

        return user;
    }
}
