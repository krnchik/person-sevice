package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.repository.MedicalCardJpaRepository;
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

    public MedicalCard findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException();
        Optional<MedicalCard> medicalCardOptional = repository.findById(id);
        return medicalCardOptional.orElse(null);
    }
}
