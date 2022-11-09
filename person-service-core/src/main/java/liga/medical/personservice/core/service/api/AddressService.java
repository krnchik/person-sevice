package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.Address;

public interface AddressService {

    void update(Address address) throws NoElementInDbException;
}
