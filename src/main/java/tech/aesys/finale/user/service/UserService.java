package tech.aesys.finale.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.aesys.finale.user.model.UserEntity;
import tech.aesys.finale.user.repository.RoleRepository;
import tech.aesys.finale.user.repository.UserRepository;
import tech.aesys.finale.user.repository.UserRoleRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserEntity> getByUsername(String username) {

        return userRepository.findByUsernameWithRoles(username);

    }

}
