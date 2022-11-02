package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.dto.AddressDto;
import liga.medical.personservice.core.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toDto(Address address);

    Address toEntity(AddressDto addressDto);

    List<AddressDto> toDtoList(List<Address> addresses);

    List<Address> toEntityList(List<AddressDto> addressDto);
}
