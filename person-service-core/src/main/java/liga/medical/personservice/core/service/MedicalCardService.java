package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.MedicalCard;

public interface MedicalCardService {
    void save(MedicalCard medicalCard);

    MedicalCard findById(Long id);
}
