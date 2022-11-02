package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.dto.MedicalCardDto;
import liga.medical.personservice.core.model.MedicalCard;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicalCardMapper {

    MedicalCardDto toDto(MedicalCard medicalCard);

    MedicalCard toEntity(MedicalCardDto medicalCardDto);

    List<MedicalCardDto> toDtoList(List<MedicalCard> medicalCard);

    List<MedicalCard> toEntityList(List<MedicalCardDto> medicalCardDto);
}
