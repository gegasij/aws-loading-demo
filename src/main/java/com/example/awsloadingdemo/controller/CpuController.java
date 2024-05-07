package com.example.awsloadingdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/random")
public class CpuController {
    @GetMapping("/random-stats")
    public ResponseEntity<Map<String, Double>> generateRandomStats(@RequestParam int count) {
        Random random = new Random();
        List<Double> numbers = IntStream.range(0, count)
                .mapToDouble(i -> random.nextDouble())
                .boxed()
                .toList();

        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        double avg = sum / count;

        Map<String, Double> stats = new HashMap<>();
        stats.put("sum", sum);
        stats.put("avg", avg);

        return ResponseEntity.ok(stats);
    }

    @GetMapping("/factorial")
    public ResponseEntity<Long> factorial(@RequestParam int n) {
        long result = IntStream.rangeClosed(1, n)
                .asLongStream()
                .reduce(1, (a, b) -> a * b);
        return ResponseEntity.ok(result);
    }
}