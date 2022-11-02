package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.dto.PersonDataDto;
import liga.medical.personservice.core.model.PersonData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonDataMapper {

    PersonDataDto toDto(PersonData personData);

    PersonData toEntity(PersonDataDto personDataDto);

    List<PersonDataDto> toDtoList(List<PersonData> personData);

    List<PersonData> toEntityList(List<PersonDataDto> personDataDto);
}
