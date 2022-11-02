package liga.medical.personservice.core.service.security;

import liga.medical.personservice.core.dto.security.UserDto;
import liga.medical.personservice.core.exception.NoUserRoleException;
import liga.medical.personservice.core.mapper.UserMapper;
import liga.medical.personservice.core.model.security.Role;
import liga.medical.personservice.core.model.security.User;
import liga.medical.personservice.core.repository.security.RoleJpaRepository;
import liga.medical.personservice.core.repository.security.UserJpaRepository;
import liga.medical.personservice.core.service.security.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userRepository;

    private final RoleJpaRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserMapper userMapper;

    @Override
    public void save(User user) throws NoUserRoleException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRole("USER"));
        if (roles.isEmpty())
            throw new NoUserRoleException();
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(user.getUsername(), user.getPassword(), user.getRoles());
    }
}
