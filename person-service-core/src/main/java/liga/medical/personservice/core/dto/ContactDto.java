package liga.medical.personservice.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    private String phoneNumber;

    private String email;

    private String profileLink;
}
