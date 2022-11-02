package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    long save(Contact contact);
}
