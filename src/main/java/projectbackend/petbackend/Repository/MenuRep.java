package projectbackend.petbackend.Repository;

import projectbackend.petbackend.Data.Dto.MenuDto;

import java.util.List;

public interface MenuRep {
    public List<MenuDto> getListMenu();
}
