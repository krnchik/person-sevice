package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.Illness;

public interface IllnessService {

    void update(Illness illness) throws NoElementInDbException;
}
