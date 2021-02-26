package projectbackend.petbackend.Data.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductsEntity {
    @Id
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_code")
    private String product_code;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "progress")
    private String progress;

}
