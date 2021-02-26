package projectbackend.petbackend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import projectbackend.petbackend.Data.Dto.MenuDto;

import java.util.List;

@Repository
public class MenuRepImpl implements MenuRep {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<MenuDto> getListMenu() {
        MapSqlParameterSource in = new MapSqlParameterSource();
        String sql = "select * from menu";
//        NamedParameterJdbcTemplate jdbcTemplateObject = new NamedParameterJdbcTemplate();
//        jdbcTemplateObject.query(sql,null, in);
        return namedParameterJdbcTemplate.query(sql, in, BeanPropertyRowMapper.newInstance(MenuDto.class));
    }
}
