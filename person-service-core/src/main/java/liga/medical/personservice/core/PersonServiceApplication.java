package liga.medical.personservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Service application.
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class PersonServiceApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class);
    }
}
