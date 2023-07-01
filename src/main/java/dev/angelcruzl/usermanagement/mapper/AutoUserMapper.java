package dev.angelcruzl.usermanagement.mapper;

import dev.angelcruzl.usermanagement.dto.UserDto;
import dev.angelcruzl.usermanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
  AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

  UserDto mapToUserDto(User user);

  User mapToUser(UserDto userDto);
}
