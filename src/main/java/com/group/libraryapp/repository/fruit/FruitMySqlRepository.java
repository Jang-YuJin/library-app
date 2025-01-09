package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.response.FruitResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FruitMySqlRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertFruit(String name, LocalDate warehousingDate, long price) {
        String sql = "insert into fruit (name, warehousingDate, price, saleYn) values (?, ?, ?, 'N')";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    public void saleFruit(long id){
        String sql = "update fruit set saleYn = 'Y' where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<FruitResponse> selectPriceFruit(String name){
        String sql = "select sum(price) as price, saleYn from fruit where name = ? group by saleYn;";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long price = rs.getLong("price");
            String saleYn = rs.getString("saleYn");
            return new FruitResponse(price, saleYn);
        }, name);
    }
}
