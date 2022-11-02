package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.dto.IllnessDto;
import liga.medical.personservice.core.model.Illness;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IllnessMapper {

    IllnessDto toDto(Illness illness);

    Illness toEntity(IllnessDto illnessDto);

    List<IllnessDto> toDtoList(List<Illness> illnesses);

    List<Illness> toEntityList(List<IllnessDto> illnessDto);
}
