package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Signal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalJpaRepository extends JpaRepository<Signal, Long> {
}
