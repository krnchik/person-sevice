package liga.medical.personservice.core.service;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.repository.PersonDataJpaRepository;
import liga.medical.personservice.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public PersonData findById(Long id) throws NoElementInDbException {
        if (id == null)
            throw new IllegalArgumentException();
        Optional<PersonData> personData = repository.findById(id);
        return personData.orElseThrow(() -> new NoElementInDbException("Not found object PersonData by id" + id));
    }

    @Override
    public List<PersonData> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) throws NoElementInDbException {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public List<PersonData> findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Transactional
    @Override
    public void update(PersonData personData) throws NoElementInDbException {
        repository.findById(personData.getId())
                .ifPresent(personData1 -> {
                    personData1.setAge(personData.getAge());
                    personData1.setPersonDatalist(personData.getPersonDatalist());
                    personData1.setBirthDt(personData.getBirthDt());
                    personData1.setFirstName(personData.getFirstName());
                    personData1.setLastName(personData.getLastName());
                    personData1.setSex(personData.getSex());
                    personData1.setMedicalCard(personData.getMedicalCard());
                    personData1.setContact(personData.getContact());
                    personData1.setPersonDatalist(personData.getPersonDatalist());

                    repository.save(personData1);
                });
    }
}
