package projectbackend.petbackend.Data.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Datatable {
    private int total;
    private int pages;
    private List<?> data;
}
