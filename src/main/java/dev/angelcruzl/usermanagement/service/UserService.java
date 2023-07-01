package dev.angelcruzl.usermanagement.service;

import dev.angelcruzl.usermanagement.dto.UserDto;

import java.util.List;

public interface UserService {
  UserDto createUser(UserDto user);

  UserDto getUserById(Long userId);

  List<UserDto> getAllUsers();

  UserDto updateUser(UserDto user);

  void deleteUser(Long userId);
}
