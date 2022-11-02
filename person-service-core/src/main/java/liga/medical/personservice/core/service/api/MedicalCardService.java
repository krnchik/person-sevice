package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.exception.NoElementInDb;
import liga.medical.personservice.core.model.MedicalCard;

public interface MedicalCardService  {
    void save(MedicalCard medicalCard);

    MedicalCard findById(Long id) throws NoElementInDb;
}
