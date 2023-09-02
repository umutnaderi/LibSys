package com.example.libsys.service;

import com.example.libsys.model.Role;
import com.example.libsys.model.UserEntity;
import com.example.libsys.repository.RoleRepository;
import com.example.libsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public void initRoleAndUser() {

//        Role adminRole = new Role();
//        adminRole.setName("ROLE_ADMIN");
//        roleRepository.save(adminRole);
//
//        Role userRole = new Role();
//        userRole.setName("ROLE_USER");
//        roleRepository.save(userRole);
//
//        UserEntity adminUser = new UserEntity();
//        adminUser.setUsername("admin123");
//        adminUser.setPassword("admin@pass"));
//        adminUser.setEmail("admin@admin.com");
//        adminUser.setFullName("admin");
//        adminUser.setRole(adminRole);
//        userRepository.save(adminUser);

    }

    public UserEntity registerNewUser(UserEntity user) {
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRole(role);
        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }
}
