package liga.medical.personservice.core.service;

import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.repository.IllnessJpaRepository;
import liga.medical.personservice.core.service.api.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IllnessServiceImpl implements IllnessService {

    private final IllnessJpaRepository repository;

    @Autowired
    public IllnessServiceImpl(IllnessJpaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void update(Illness illness) throws NoElementInDbException {
        if (repository.findById(illness.getId()).isEmpty())
            throw new NoElementInDbException();
        repository.findById(illness.getId())
                .ifPresent(illness1 -> {
                    illness1.setAppearanceDttm(illness.getAppearanceDttm());
                    illness1.setHeaviness(illness.getHeaviness());
                    illness1.setTypeId(illness.getTypeId());
                    illness1.setRecoveryDt(illness.getRecoveryDt());
                    illness1.setMedicalCard(illness.getMedicalCard());

                    repository.save(illness1);
                });
    }
}
