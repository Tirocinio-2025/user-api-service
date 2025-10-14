package tech.aesys.finale.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tech.aesys.finale.user.model.AuthRequest;
import tech.aesys.finale.user.repository.RoleRepository;
import tech.aesys.finale.user.repository.UserRepository;
import tech.aesys.finale.user.repository.UserRoleRepository;
import tech.aesys.finale.user.security.util.JwtUtils;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationProvider authManager;
    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;


    public String login(AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        return jwtUtils.generateToken(userDetails);
    }

    public void logout() {
    }
}
