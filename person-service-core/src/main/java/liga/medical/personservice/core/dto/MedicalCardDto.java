package liga.medical.personservice.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardDto implements Serializable {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    private String clientStatus;

    private String medStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    private Date registryDt;

    private String comment;
}
