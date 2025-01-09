package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.service.fruit.FruitJpaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FruitController {
//    FruitService fruitService;
    FruitJpaService fruitService;

    public FruitController(FruitJpaService fruitService) {
        this.fruitService = fruitService;
    }

//    public FruitController(FruitJpaService fruitService) {
//        this.fruitService = fruitService;
//    }
//
//    @PostMapping("/api/v1/fruit")
//    public void insertFruit(@RequestBody Fruit fruit) {
//        fruitService.insertFruit(fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice());
//    }
//
//    @PutMapping("/api/v1/fruit")
//    public void saleFruit(@RequestBody Fruit fruit) {
//        fruitService.saleFruit(fruit.getId());
//    }
//
//    @GetMapping("/api/v1/fruit/stat")
//    public Map<String, Object> selectPriceFruit(@RequestParam String name) {
//        return fruitService.selectPriceFruit(name);
//    }

    @GetMapping("/api/v1/fruit/count")
    public Map<String, Object> selectCountFruit(@RequestParam String name) {
        return fruitService.selectCountFruit(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<Fruit> selectFruits(@RequestParam String option, @RequestParam long price) {
        return fruitService.selectFruits(option, price);
    }
}
