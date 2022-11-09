package liga.medical.personservice.core.service;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.repository.MedicalCardJpaRepository;
import liga.medical.personservice.core.service.api.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardJpaRepository repository;

    @Autowired
    public MedicalCardServiceImpl(MedicalCardJpaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void update(MedicalCard medicalCard) throws NoElementInDbException {
        if (repository.findById(medicalCard.getId()).isEmpty())
            throw new NoElementInDbException();
        repository.findById(medicalCard.getId())
                .ifPresent(medicalCard1 -> {
                    medicalCard1.setClientStatus(medicalCard.getClientStatus());
                    medicalCard1.setRegistryDt(medicalCard.getRegistryDt());
                    medicalCard1.setComment(medicalCard.getComment());
                    medicalCard1.setPersonData(medicalCard.getPersonData());
                    medicalCard1.setIllnesses(medicalCard.getIllnesses());

                    repository.save(medicalCard1);
                });
    }
}
