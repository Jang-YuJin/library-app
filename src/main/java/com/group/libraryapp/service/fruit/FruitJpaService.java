package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.response.FruitResponse;
import com.group.libraryapp.repository.fruit.FruitMySqlRepository;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FruitJpaService {
    private final FruitRepository fruitRepository;

    public FruitJpaService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Map<String, Object> selectCountFruit(String name) {
        long count = fruitRepository.countByNameAndSaleYn(name, "N");

        Map<String, Object> result = new HashMap<>();
        result.put("count", count);

        return result;
    }

    public List<Fruit> selectFruits(String option, long price) {
        List<Fruit> resultList = new ArrayList<>();

        if("GTE".equals(option)){
            resultList = fruitRepository.findAllByPriceGreaterThanEqual(price);
        }else{
            resultList = fruitRepository.findAllByPriceLessThanEqual(price);
        }

        return resultList;
    }
}
