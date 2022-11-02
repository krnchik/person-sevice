package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.dto.ContactDto;
import liga.medical.personservice.core.model.Contact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactDto toDto(Contact contact);

    Contact toEntity(ContactDto contactDto);

    List<ContactDto> toDtoList(List<Contact> contacts);

    List<Contact> toEntityList(List<ContactDto> contactDto);
}
