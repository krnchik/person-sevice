package liga.medical.personservice.core.dto;

import liga.medical.personservice.core.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private long id;

    private long countryId;

    private String city;

    private long index;

    private String street;

    private String building;

    private String flat;

    private Contact contact;
}
