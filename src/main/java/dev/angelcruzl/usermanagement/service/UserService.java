package dev.angelcruzl.usermanagement.service;

import dev.angelcruzl.usermanagement.entity.User;

import java.util.List;

public interface UserService {
  User createUser(User user);

  User getUserById(Long userId);

  List<User> getAllUsers();

  User updateUser(User user);

  void deleteUser(Long userId);
}
