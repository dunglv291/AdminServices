package projectbackend.petbackend.Data.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {
    @Id
    @Column(name = "menu_id")
    private Long menuId;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_code")
    private String menuCode;
}
