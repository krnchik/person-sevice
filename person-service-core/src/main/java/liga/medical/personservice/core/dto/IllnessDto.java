package liga.medical.personservice.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import liga.medical.personservice.core.model.MedicalCard;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class IllnessDto implements Serializable {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    private long typeId;

    private String heaviness;

    private java.sql.Timestamp appearanceDttm;

    private java.sql.Date recoveryDt;

    private MedicalCard medicalCard;
}
