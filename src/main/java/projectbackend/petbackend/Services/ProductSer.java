package projectbackend.petbackend.Services;
import projectbackend.petbackend.Data.Dto.Datatable;
import projectbackend.petbackend.Data.Dto.ProductsDto;

import java.util.List;

public interface ProductSer {
    public List<ProductsDto> getListProductsAll();

    Datatable getDatatableAllProduct(ProductsDto productsDto);
}
