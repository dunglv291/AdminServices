package projectbackend.petbackend.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.petbackend.Services.UserSer;
import projectbackend.petbackend.Data.Dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserSer userSer;

    @PostMapping(path = "/getDetail")
    public ResponseEntity<UserDto> getGreetings(@RequestBody UserDto userForm){
        UserDto userDto = userSer.getById(userForm.getUserId());
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

}
