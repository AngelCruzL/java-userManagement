package dev.angelcruzl.usermanagement.service;

import dev.angelcruzl.usermanagement.dto.UserDto;
import dev.angelcruzl.usermanagement.entity.User;

import java.util.List;

public interface UserService {
  UserDto createUser(UserDto user);

  User getUserById(Long userId);

  List<User> getAllUsers();

  User updateUser(User user);

  void deleteUser(Long userId);
}
