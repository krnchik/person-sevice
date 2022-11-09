package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.MedicalCard;

public interface MedicalCardService  {
    void update(MedicalCard medicalCard) throws NoElementInDbException;
}
