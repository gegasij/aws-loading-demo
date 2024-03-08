package com.example.awsloadingdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
@RequestMapping("/random")
public class RandomNumbersController {
    @GetMapping("/{count}")
    public List<Integer> getRandomNumber(@PathVariable("count") Integer count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(RandomGenerator.getDefault().nextInt());
        }
        return numbers;
    }

}