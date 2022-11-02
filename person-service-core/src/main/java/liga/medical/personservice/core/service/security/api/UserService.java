package liga.medical.personservice.core.service.security.api;

import liga.medical.personservice.core.dto.security.UserDto;
import liga.medical.personservice.core.exception.NoUserRoleException;
import liga.medical.personservice.core.model.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(User user) throws NoUserRoleException;

    User findByUsername(String username);

    List<UserDto> getUsers();

    boolean deleteUser(Long userId);
}
