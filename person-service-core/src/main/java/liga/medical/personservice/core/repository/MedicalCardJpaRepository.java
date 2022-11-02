package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCardJpaRepository extends JpaRepository<MedicalCard, Long> {
}
