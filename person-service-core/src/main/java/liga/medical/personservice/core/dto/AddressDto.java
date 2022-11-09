package liga.medical.personservice.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import liga.medical.personservice.core.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    private long countryId;

    private String city;

    private long index;

    private String street;

    private String building;

    private String flat;

    private Contact contact;
}
