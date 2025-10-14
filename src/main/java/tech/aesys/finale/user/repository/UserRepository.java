package tech.aesys.finale.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.aesys.finale.user.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
