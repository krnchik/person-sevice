package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJpaRepository extends JpaRepository<Address, Long> {
}
