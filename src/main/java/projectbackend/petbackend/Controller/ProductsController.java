package projectbackend.petbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.petbackend.Data.Dto.Datatable;
import projectbackend.petbackend.Services.ProductSer;
import projectbackend.petbackend.Data.Dto.ProductsDto;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    @Autowired
    ProductSer productSer;

    @GetMapping(path = "/getListProductsAll")
    public ResponseEntity<List<ProductsDto>> getListProductsAll(){
        List<ProductsDto> listResult = productSer.getListProductsAll();
        return new ResponseEntity<>(listResult, HttpStatus.OK);
    }

    @PostMapping(path = "/getDatatableAllProduct")
    public ResponseEntity<Datatable> getDatatableAllProduct(@RequestBody ProductsDto productsDto){
        Datatable datatable = productSer.getDatatableAllProduct(productsDto);
        return  new ResponseEntity<>(datatable, HttpStatus.OK);
    }


}
