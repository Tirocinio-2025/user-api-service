package tech.aesys.finale.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import tech.aesys.finale.user.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.aesys.finale.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsernameWithRoles(username)
                                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword()) // password già codificata
                .roles() // es. "ADMIN"
                .build();
    }
}
