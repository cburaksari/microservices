package user.service.demo.service;

import java.util.Optional;

import user.service.demo.models.User;
import user.service.demo.models.dto.UserDTO;
import user.service.demo.models.dto.UserRegistrationDTO;

public interface IUserService {
    User createUser(UserRegistrationDTO userRegistrationDTO);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    User updateUser(Long userId, UserDTO userDTO);

    void deleteUser(Long userId);
}
