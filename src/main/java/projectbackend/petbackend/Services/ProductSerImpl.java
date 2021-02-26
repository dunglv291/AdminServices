package projectbackend.petbackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.petbackend.Data.Dto.Datatable;
import projectbackend.petbackend.Repository.ProductRep;
import projectbackend.petbackend.Data.Dto.ProductsDto;

import java.util.List;

@Service
public class ProductSerImpl implements ProductSer {
    @Autowired
    ProductRep productRep;

    @Override
    public List<ProductsDto> getListProductsAll() {
        return productRep.getListProductsAll();
    }

    @Override
    public Datatable getDatatableAllProduct(ProductsDto productsDto) {
        return productRep.getDatatableProducts(productsDto);
    }
}
