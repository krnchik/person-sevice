package liga.medical.personservice.core.service;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.repository.ContactJpaRepository;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactJpaRepository repository;

    @Autowired
    public ContactServiceImpl(ContactJpaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void update(Contact contact) throws NoElementInDbException {
        if (repository.findById(contact.getId()).isEmpty())
            throw new NoElementInDbException();
        repository.findById(contact.getId())
                .ifPresent(contact1 -> {
                    contact1.setProfileLink(contact.getProfileLink());
                    contact1.setEmail(contact.getEmail());
                    contact1.setPhoneNumber(contact.getPhoneNumber());
                    contact1.setPersonData(contact.getPersonData());
                    contact1.setAddresses(contact.getAddresses());

                    repository.save(contact1);
                });
    }
}
