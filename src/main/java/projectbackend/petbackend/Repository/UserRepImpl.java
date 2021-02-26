package projectbackend.petbackend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import projectbackend.petbackend.Data.Dto.UserDto;
import projectbackend.petbackend.Data.Entity.UserEntity;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepImpl implements UserRep {

    @Autowired
    EntityManager entityManager;

    @Override
    public UserDto getById(Long id) {
        UserDto userDto = new UserDto();
        try {
            UserEntity userEntity = entityManager.find(UserEntity.class, id );
            userDto = userEntity.toDto();
            return userDto;
        }catch (Exception e){
            e.getMessage();
        }
       return userDto;
    }

    @Override
    public List<UserDto> getListUser() {
        return null;
    }
}
