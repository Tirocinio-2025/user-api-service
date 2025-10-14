package tech.aesys.finale.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.aesys.finale.user.model.RoleEntity;
import tech.aesys.finale.user.model.UserEntity;
import tech.aesys.finale.user.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUser(UserEntity user);

    List<UserRole> findByRole(RoleEntity role);

    Optional<UserRole> findByUserAndRole(UserEntity user, RoleEntity role);

    @Query("""
        SELECT ur.role.name
        FROM UserRole ur
        WHERE ur.user.username = :username
        """)
    List<String> findRoleNamesByUsername(String username);
}
