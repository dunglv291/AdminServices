package projectbackend.petbackend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import projectbackend.petbackend.Common.dto.BaseDTO;
import projectbackend.petbackend.Common.repository.BaseRepository;
import projectbackend.petbackend.Data.Dto.Datatable;
import projectbackend.petbackend.Data.Dto.ProductsDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepImpl extends BaseRepository implements ProductRep {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<ProductsDto> getListProductsAll() {
        MapSqlParameterSource in = new MapSqlParameterSource();
        String sql = "select * from Products";
        return namedParameterJdbcTemplate.query(sql, in, BeanPropertyRowMapper.newInstance(ProductsDto.class));
    }

    @Override
    public Datatable getDatatableProducts(ProductsDto productsDto) {
        BaseDTO baseDTO = sqlSearch(productsDto);
        return getListDataTableBySqlQuery(baseDTO.getSqlQuery(), baseDTO.getParameters(), productsDto.getPage(), productsDto.getPageSize(),
                ProductsDto.class, productsDto.getSortName(), productsDto.getSortType());
    }

    private BaseDTO sqlSearch(ProductsDto productsDto) {
        BaseDTO baseDTO = new BaseDTO();
        Map<String, Object> parameter = new HashMap<>();
        String sql = getSQLFromFile("product", "searchAll");
        baseDTO.setSqlQuery(sql);
        baseDTO.setParameters(parameter);
        return baseDTO;
    }

}
