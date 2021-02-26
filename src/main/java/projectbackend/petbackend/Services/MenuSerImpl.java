package projectbackend.petbackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.petbackend.Repository.MenuRep;
import projectbackend.petbackend.Data.Dto.MenuDto;

import java.util.List;

@Service
public class MenuSerImpl implements MenuSer {
    @Autowired
    MenuRep menuRep;


    @Override
    public List<MenuDto> getListMenu() {
        return menuRep.getListMenu();
    }
}
