package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.Contact;

public interface ContactService {
    void update(Contact contact) throws NoElementInDbException;
}
