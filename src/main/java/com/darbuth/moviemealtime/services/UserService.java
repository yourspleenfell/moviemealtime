package com.darbuth.moviemealtime.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.darbuth.moviemealtime.models.User;
import com.darbuth.moviemealtime.repositories.RoleRepo;
import com.darbuth.moviemealtime.repositories.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo;
    private RoleRepo roleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_USER"));
        userRepo.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        userRepo.save(user);
    }    
    
    // 3
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    public List<User> findAllUsers() {
    	return userRepo.findAll();
    }
    
    public void updateUser(User user) {
    	userRepo.save(user);
    }

}
