package projectbackend.petbackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectbackend.petbackend.Services.MenuSer;
import projectbackend.petbackend.Data.Dto.MenuDto;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuSer menuSer;

    @GetMapping(path = "/getAllMenu")
    public ResponseEntity<List<MenuDto>> getAllMenu(){
        List<MenuDto> listMenu = menuSer.getListMenu();
        return new ResponseEntity<>(listMenu, HttpStatus.OK);
    }



}
