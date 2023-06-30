package dev.angelcruzl.usermanagement.repository;

import dev.angelcruzl.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
