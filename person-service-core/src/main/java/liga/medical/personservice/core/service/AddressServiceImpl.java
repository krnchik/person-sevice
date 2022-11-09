package liga.medical.personservice.core.service;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.repository.AddressJpaRepository;
import liga.medical.personservice.core.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressJpaRepository repository;

    @Autowired
    public AddressServiceImpl(AddressJpaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void update(Address address) throws NoElementInDbException {
        if (repository.findById(address.getId()).isEmpty())
            throw new NoElementInDbException();
        repository.findById(address.getId())
                .ifPresent(address1 -> {
                    address1.setBuilding(address.getBuilding());
                    address1.setCity(address.getCity());
                    address1.setFlat(address.getFlat());
                    address1.setContact(address.getContact());
                    address1.setIndex(address.getIndex());
                    address1.setCountryId(address.getCountryId());
                    address1.setStreet(address.getStreet());

                    repository.save(address1);
                });
    }
}
