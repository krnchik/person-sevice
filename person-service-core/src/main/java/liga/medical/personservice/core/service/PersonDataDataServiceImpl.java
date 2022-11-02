package liga.medical.personservice.core.service;

import liga.medical.personservice.core.exception.NoElementInDb;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.repository.PersonDataJpaRepository;
import liga.medical.personservice.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDataDataServiceImpl implements PersonDataService {

    private final PersonDataJpaRepository repository;

    @Autowired
    public PersonDataDataServiceImpl(PersonDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(PersonData personData) {
        repository.save(personData);
    }

    @Override
    public PersonData findById(Long id) throws NoElementInDb {
        if (id == null)
            throw new IllegalArgumentException();
        Optional<PersonData> personData = repository.findById(id);
        return personData.orElseThrow(() -> new NoElementInDb("Not found object PersonData by id" + id));
    }

    @Override
    public List<PersonData> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) throws NoElementInDb {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public List<PersonData> findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }
}
