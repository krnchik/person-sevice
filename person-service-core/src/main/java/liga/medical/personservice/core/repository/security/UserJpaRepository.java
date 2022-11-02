package liga.medical.personservice.core.repository.security;

import liga.medical.personservice.core.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
