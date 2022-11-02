package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.dto.security.UserDto;
import liga.medical.personservice.core.model.security.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> user);

    List<User> toEntityList(List<UserDto> userDto);
}
