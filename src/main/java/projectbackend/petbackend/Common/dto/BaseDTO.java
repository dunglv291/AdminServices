package projectbackend.petbackend.Common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class BaseDTO {

    private Integer page;
    private Integer pageSize;
    private String sortName;
    private String sortType;
    private Integer totalRow;
    private Integer indexRow;
    private String langKey;
    private String timeOffset;
    private String sqlQuery;
    private List<Long> listId;
    private Map<String, Object> parameters;
    private String searchAll;
    private String proxyLocale;

}
