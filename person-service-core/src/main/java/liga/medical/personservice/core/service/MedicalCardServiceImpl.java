package liga.medical.personservice.core.service;

import liga.medical.personservice.core.exception.NoElementInDb;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.repository.MedicalCardJpaRepository;
import liga.medical.personservice.core.service.api.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardJpaRepository repository;

    @Autowired
    public MedicalCardServiceImpl(MedicalCardJpaRepository repository) {
        this.repository = repository;
    }

    public void save(MedicalCard medicalCard) {
        repository.save(medicalCard);
    }

    public MedicalCard findById(Long id) throws NoElementInDb {
        if (id == null)
            throw new IllegalArgumentException();
        Optional<MedicalCard> medicalCard = repository.findById(id);
        return medicalCard.orElseThrow(() -> new NoElementInDb("Not found object MedicalCard by id" + id));
    }
}
