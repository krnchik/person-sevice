package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.PersonData;

import java.util.List;

public interface PersonDataService {

    void save(PersonData personData);

    PersonData findById(Long id) throws NoElementInDbException;

    List<PersonData> findAll();

    void deleteById(Long id) throws NoElementInDbException;

    List<PersonData> findByFirstNameAndLastName(String firstName, String lastName);

    void update(PersonData personData) throws NoElementInDbException;
}
