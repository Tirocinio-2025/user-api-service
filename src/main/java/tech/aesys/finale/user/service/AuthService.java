package tech.aesys.finale.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.aesys.finale.user.repository.RoleRepository;
import tech.aesys.finale.user.repository.UserRepository;
import tech.aesys.finale.user.repository.UserRoleRepository;

@Service
public @RequiredArgsConstructor class AuthService {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;


    public void login() {
    }

    public void logout() {
    }
}
