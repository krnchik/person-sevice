package liga.medical.personservice.core.service.api;

public interface RabbitMQListener {

    void alert(String str);

    void daily(String str);
}
