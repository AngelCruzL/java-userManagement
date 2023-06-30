package dev.angelcruzl.usermanagement.controller;

import dev.angelcruzl.usermanagement.entity.User;
import dev.angelcruzl.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
  private UserService userService;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userService.createUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
    User user = userService.getUserById(userId);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}
