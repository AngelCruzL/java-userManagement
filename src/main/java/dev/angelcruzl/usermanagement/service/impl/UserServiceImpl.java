package dev.angelcruzl.usermanagement.service.impl;

import dev.angelcruzl.usermanagement.dto.UserDto;
import dev.angelcruzl.usermanagement.entity.User;
import dev.angelcruzl.usermanagement.exception.EmailAlreadyExistsException;
import dev.angelcruzl.usermanagement.exception.ResourceNotFoundException;
import dev.angelcruzl.usermanagement.mapper.AutoUserMapper;
import dev.angelcruzl.usermanagement.repository.UserRepository;
import dev.angelcruzl.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private ModelMapper modelMapper;

  @Override
  public UserDto createUser(UserDto userDto) {
    Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

    if (optionalUser.isPresent()) {
      throw new EmailAlreadyExistsException(
          String.format("User with email \"%s\" already exists", userDto.getEmail())
      );
    }

    // User user = UserMapper.mapToUser(userDto);
    // User user = modelMapper.map(userDto, User.class);
    User user = AutoUserMapper.MAPPER.mapToUser(userDto);
    User savedUser = userRepository.save(user);

    // return UserMapper.mapToUserDto(savedUser);
    // return modelMapper.map(savedUser, UserDto.class);
    return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
  }

  @Override
  public UserDto getUserById(Long userId) {
    User user = userRepository.findById(userId).orElseThrow(
        () -> new ResourceNotFoundException("User", "id", userId)
    );

    // return UserMapper.mapToUserDto(user);
    // return modelMapper.map(user, UserDto.class);
    return AutoUserMapper.MAPPER.mapToUserDto(user);
  }

  @Override
  public List<UserDto> getAllUsers() {
    List<User> users = userRepository.findAll();

//    return users.stream()
//        .map(UserMapper::mapToUserDto)
//        .toList();
//    return users.stream()
//        .map(user -> modelMapper.map(user, UserDto.class))
//        .toList();
    return users.stream()
        .map(user -> AutoUserMapper.MAPPER.mapToUserDto(user))
        .toList();
  }

  @Override
  public UserDto updateUser(UserDto user) {
    User existingUser = userRepository.findById(user.getId()).orElseThrow(
        () -> new ResourceNotFoundException("User", "id", user.getId())
    );

    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    existingUser.setEmail(user.getEmail());

    User updatedUser = userRepository.save(existingUser);
    // return UserMapper.mapToUserDto(updatedUser);
    // return modelMapper.map(updatedUser, UserDto.class);
    return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
  }

  @Override
  public void deleteUser(Long userId) {
    User existingUser = userRepository.findById(userId).orElseThrow(
        () -> new ResourceNotFoundException("User", "id", userId)
    );

    userRepository.deleteById(userId);
  }
}
