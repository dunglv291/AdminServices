package projectbackend.petbackend.Common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultInsideDTO {
    private Long id;
    private String key;
    private String messages;
    private Object object;
}
