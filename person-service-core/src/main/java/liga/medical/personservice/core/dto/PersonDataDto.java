package liga.medical.personservice.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.model.PersonData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDataDto implements Serializable {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private java.sql.Date birthDt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long age;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sex;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Contact contact;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MedicalCard medicalCard;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PersonData personData;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<PersonData> personDatalist;
}
