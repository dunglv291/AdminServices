package projectbackend.petbackend.Repository;

import projectbackend.petbackend.Data.Dto.UserDto;

import java.util.List;

public interface UserRep {
    public UserDto getById(Long id);

    public List<UserDto> getListUser();
}
