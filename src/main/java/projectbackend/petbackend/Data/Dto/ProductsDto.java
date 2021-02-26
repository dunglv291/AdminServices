package projectbackend.petbackend.Data.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projectbackend.petbackend.Common.dto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductsDto extends BaseDTO {
    private Long productId;
    private String productName;
    private String productCode;
    private String description;
    private String price;
    private String manufacturer;
    private String progress;
}
