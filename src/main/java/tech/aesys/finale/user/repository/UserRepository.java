package tech.aesys.finale.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.aesys.finale.user.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Eager fetch dei ruoli (utile per il tuo UserDetailsService)
    @Query("""
        SELECT u FROM UserEntity u
        LEFT JOIN FETCH u.userRoles ur
        LEFT JOIN FETCH ur.role
        WHERE u.username = :username
        """)
    Optional<UserEntity> findByUsernameWithRoles(String username);
}
