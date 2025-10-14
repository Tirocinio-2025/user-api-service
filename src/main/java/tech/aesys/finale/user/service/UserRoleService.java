package tech.aesys.finale.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.aesys.finale.user.model.RoleEntity;
import tech.aesys.finale.user.repository.RoleRepository;
import tech.aesys.finale.user.repository.UserRepository;
import tech.aesys.finale.user.repository.UserRoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository urr;
    private final UserRepository ur;
    private final RoleRepository rr;



}
