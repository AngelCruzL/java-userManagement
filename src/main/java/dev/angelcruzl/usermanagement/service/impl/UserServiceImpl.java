package dev.angelcruzl.usermanagement.service.impl;

import dev.angelcruzl.usermanagement.dto.UserDto;
import dev.angelcruzl.usermanagement.entity.User;
import dev.angelcruzl.usermanagement.mapper.UserMapper;
import dev.angelcruzl.usermanagement.repository.UserRepository;
import dev.angelcruzl.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  @Override
  public UserDto createUser(UserDto userDto) {
    User user = UserMapper.mapToUser(userDto);
    User savedUser = userRepository.save(user);

    return UserMapper.mapToUserDto(savedUser);
  }

  @Override
  public UserDto getUserById(Long userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    User user = optionalUser.get();
    return UserMapper.mapToUserDto(user);
  }

  @Override
  public List<UserDto> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
        .map(UserMapper::mapToUserDto)
        .toList();
  }

  @Override
  public UserDto updateUser(UserDto user) {
    User existingUser = userRepository.findById(user.getId()).get();
    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    existingUser.setEmail(user.getEmail());

    User updatedUser = userRepository.save(existingUser);
    return UserMapper.mapToUserDto(updatedUser);
  }

  @Override
  public void deleteUser(Long userId) {
    userRepository.deleteById(userId);
  }
}
