package projectbackend.petbackend.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.petbackend.Repository.UserRep;
import projectbackend.petbackend.Data.Dto.UserDto;

@Service
public class UserSerImpl implements UserSer {
    @Autowired
    UserRep userRep;

    @Override
    public UserDto getById(Long id) {
        return userRep.getById(id);
    }
}
