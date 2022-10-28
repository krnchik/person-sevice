package liga.medical.personservice.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import liga.medical.personservice.core.model.MedicalCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardDto implements Serializable {
    private String clientStatus;
    private String medStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date registryDt;
    private String comment;

    public MedicalCard convertToMedicalCard() {
        MedicalCard medicalCard = new MedicalCard();
        medicalCard.setClientStatus(getClientStatus());
        medicalCard.setMedStatus(getMedStatus());
        medicalCard.setComment(getComment());
        medicalCard.setRegistryDt(getRegistryDt());
        return medicalCard;
    }

    public MedicalCardDto fromMedicalCard(MedicalCard medicalCard) {
        MedicalCardDto medicalCardDto = new MedicalCardDto();
        medicalCardDto.setClientStatus(medicalCard.getClientStatus());
        medicalCardDto.setMedStatus(medicalCard.getMedStatus());
        medicalCardDto.setRegistryDt(medicalCard.getRegistryDt());
        medicalCardDto.setComment(medicalCard.getComment());
        return medicalCardDto;
    }
}
