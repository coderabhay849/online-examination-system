package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.dto.AdminUserRequest;
import com.example.onlineexamination.entity.Role;
import com.example.onlineexamination.entity.User;
import com.example.onlineexamination.repository.RoleRepository;
import com.example.onlineexamination.repository.UserRepository;
import com.example.onlineexamination.service.AdminUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUserServiceImpl(UserRepository userRepository,
                                RoleRepository roleRepository,
                                PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String createUser(AdminUserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already registered";
        }

        Role role = roleRepository
                .findByName(request.getRole().toUpperCase())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        user.setEnabled(true);

        userRepository.save(user);

        return "User created successfully";
    }
}