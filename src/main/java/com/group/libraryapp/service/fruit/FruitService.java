package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.response.FruitResponse;
import com.group.libraryapp.repository.fruit.FruitMySqlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FruitService {
    FruitMySqlRepository fruitRepository;

    public FruitService(FruitMySqlRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void insertFruit(String name, LocalDate warehousingDate, long price){
        fruitRepository.insertFruit(name, warehousingDate, price);
    }

    public void saleFruit(long id){
        fruitRepository.saleFruit(id);
    }

    public Map<String, Object> selectPriceFruit(String name){
        List<FruitResponse> list = fruitRepository.selectPriceFruit(name);

        Map<String, Object> result = new HashMap<>();
        result.put("salesAmount", list.get(0).getSaleYn().equals("Y") ? list.get(0).getPrice() : list.get(1).getPrice());
        result.put("notSalesAmount", list.get(0).getSaleYn().equals("N") ? list.get(0).getPrice() : list.get(1).getPrice());

        return result;
    }
}
