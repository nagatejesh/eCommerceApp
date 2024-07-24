package com.nbc.ecommerceApp.service;

import com.nbc.ecommerceApp.model.User;
import com.nbc.ecommerceApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not available with username " + username));
        UserDetails usr = org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.getPassword()).authorities(user.getAuthorities()).build();

        return usr;
    }
}
