package liga.medical.personservice.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.dto.RabbitMessageDto;
import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.model.Signal;
import liga.medical.personservice.core.repository.PersonDataJpaRepository;
import liga.medical.personservice.core.repository.SignalJpaRepository;
import liga.medical.personservice.core.service.api.RabbitMQListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMQListenerImpl implements RabbitMQListener {

    private final SignalJpaRepository repository;

    private final PersonDataJpaRepository repositoryPersonData;

    @Autowired
    public RabbitMQListenerImpl(SignalJpaRepository repository, PersonDataJpaRepository repositoryPersonData) {
        this.repository = repository;
        this.repositoryPersonData = repositoryPersonData;
    }

    @RabbitListener(queues = "daily_queue")
    public void daily(String str) {
        handle(str);
    }

    @RabbitListener(queues = "alert_queue")
    public void alert(String str) {
        handle(str);
    }

    @DbLog
    private void handle(String str) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RabbitMessageDto message = objectMapper.readValue(str, RabbitMessageDto.class);
            Signal signal = toSignal(message);
            if (repositoryPersonData.findById(signal.getId()).isEmpty())
                throw new NoElementInDbException();
            else {
                signal.setPersonData(repositoryPersonData.findById(signal.getId()).get());
                repository.save(signal);
            }
        } catch (IOException | NoElementInDbException e) {
            e.printStackTrace();
        }
    }

    private Signal toSignal(RabbitMessageDto rabbitMessageDto) {
        Signal signal = new Signal();
        signal.setId(rabbitMessageDto.getId());
        signal.setType(rabbitMessageDto.getType());
        signal.setDescription(rabbitMessageDto.getDescription());
        return signal;
    }
}
