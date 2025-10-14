package tech.aesys.finale.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.aesys.finale.user.model.UserRole;
import tech.aesys.finale.user.model.UserRolePK;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {

}
