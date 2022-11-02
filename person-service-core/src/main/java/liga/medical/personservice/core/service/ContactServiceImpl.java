package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.repository.ContactMapper;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactMapper mapper;

    @Autowired
    public ContactServiceImpl(ContactMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Contact> findAll() {
        return mapper.findAll();
    }

    @Override
    public long save(Contact contact) {
        return mapper.save(contact);
    }
}
