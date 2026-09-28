package com.example.onlineexamination.security;

import com.example.onlineexamination.entity.User;
import com.example.onlineexamination.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(JwtService jwtService,
                                   UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if (jwtService.isValid(token)) {

                String email = jwtService.extractEmail(token);

                User user = userRepository.findByEmail(email).orElse(null);

                if(user != null && token.equals(user.getActiveToken())){

                    String role = user.getRole().getName();

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    user.getEmail(),
                                    null,
                                    Collections.singletonList(
                                            new SimpleGrantedAuthority("ROLE_" + role)
                                    )
                            );

                    SecurityContextHolder.getContext()
                            .setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}