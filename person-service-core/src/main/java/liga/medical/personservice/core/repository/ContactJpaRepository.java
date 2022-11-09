package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactJpaRepository extends JpaRepository<Contact, Long> {
}
