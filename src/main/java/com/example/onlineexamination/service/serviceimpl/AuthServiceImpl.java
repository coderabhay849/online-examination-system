package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.dto.AuthResponse;
import com.example.onlineexamination.dto.LoginRequest;
import com.example.onlineexamination.dto.RegisterRequest;
import com.example.onlineexamination.entity.Role;
import com.example.onlineexamination.entity.User;
import com.example.onlineexamination.repository.RoleRepository;
import com.example.onlineexamination.repository.UserRepository;
import com.example.onlineexamination.security.JwtService;
import com.example.onlineexamination.service.AuditLogService;
import com.example.onlineexamination.service.AuthService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuditLogService auditLogService;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService,AuditLogService auditLogService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.auditLogService = auditLogService;
    }

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already registered";
        }

        Role role = roleRepository.findByName("STUDENT")
                .orElseThrow(() ->
                        new RuntimeException("STUDENT role not found"));

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        user.setRole(role);
        user.setEnabled(true);

        userRepository.save(user);

        return "Student registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole().getName()
        );

        user.setActiveToken(token);
        userRepository.save(user);

        auditLogService.saveLog(
                "LOGIN",
                user.getEmail(),
                "User logged in successfully"
        );

        return new AuthResponse(token, user.getRole().getName());

       
    }
}