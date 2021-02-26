package projectbackend.petbackend.Repository;
import projectbackend.petbackend.Data.Dto.Datatable;
import projectbackend.petbackend.Data.Dto.ProductsDto;

import java.util.List;

public interface ProductRep {

    public List<ProductsDto> getListProductsAll();

    Datatable getDatatableProducts(ProductsDto productsDto);
}
