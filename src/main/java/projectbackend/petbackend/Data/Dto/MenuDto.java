package projectbackend.petbackend.Data.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MenuDto {
    private Long menuId;
    private String menuName;
    private String menuCode;
}
