package liga.medical.personservice.core.repository.security;

import liga.medical.personservice.core.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
