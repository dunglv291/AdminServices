package projectbackend.petbackend.Services;

import projectbackend.petbackend.Data.Dto.UserDto;

public interface UserSer {
    public UserDto getById(Long id);
}
