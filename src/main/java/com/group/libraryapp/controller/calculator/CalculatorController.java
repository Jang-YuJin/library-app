package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.*;
import com.group.libraryapp.dto.response.CalculatorResponse;
import com.group.libraryapp.dto.response.DayOfTHeWeekResponse;
import com.group.libraryapp.dto.response.FruitResponse;
import com.group.libraryapp.dto.response.UserResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalculatorController {
    private final JdbcTemplate jdbcTemplate;

    public CalculatorController(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/add")
    public int addTwoNumbers(@RequestParam int number1, @RequestParam int number2) {
        return number1 + number2;
    }

    @GetMapping("/add2")
    public int addTwoNumbers2(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTowNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

    @GetMapping("/api/v1/calc")
    public CalculatorResponse calc(@RequestParam int num1, @RequestParam int num2) {
        int add = num1 + num2;
        int minus = num1 - num2;
        int multiply = num1 * num2;
        return new CalculatorResponse(add, minus, multiply);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayOfTHeWeekResponse dayOfTheWeek(@RequestParam String dayOfTheWeek) {
        return new DayOfTHeWeekResponse(dayOfTheWeek);
    }

    @PostMapping("/listAdd")
    public int listAdd(@RequestBody ListAddRequest numbers){
        List<Integer> list = numbers.getNumbers();
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }
}
