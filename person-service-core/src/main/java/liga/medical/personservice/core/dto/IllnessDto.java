package liga.medical.personservice.core.dto;

import liga.medical.personservice.core.model.MedicalCard;
import lombok.Data;

@Data
public class IllnessDto {

    private long id;

    private long typeId;

    private String heaviness;

    private java.sql.Timestamp appearanceDttm;

    private java.sql.Date recoveryDt;

    private MedicalCard medicalCard;
}
