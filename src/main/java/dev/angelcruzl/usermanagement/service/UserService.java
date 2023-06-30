package dev.angelcruzl.usermanagement.service;

import dev.angelcruzl.usermanagement.entity.User;

public interface UserService {
  User createUser(User user);

  User getUserById(Long userId);
}
