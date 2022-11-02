package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDataJpaRepository extends JpaRepository<PersonData, Long> {

    List<PersonData> findByFirstNameAndLastName(String firstName, String lastName);
}
