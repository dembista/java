package com.example.java_burger.services;

import com.example.java_burger.models.Admin;
import com.example.java_burger.models.Role;
import com.example.java_burger.models.User;
import com.example.java_burger.repositories.AdminRepository;
import com.example.java_burger.repositories.RoleRepository;
import com.example.java_burger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Role findRoleByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle);
    }

    public User saveUser(User user) {
        try {
            userRepository.save(user);
            return user;
        } catch(Exception e) {
            throw e;
        }
    }
}
