package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalCardJpaRepository extends JpaRepository<MedicalCard, Long> {
    Optional<MedicalCard> findById(Long id);
}
