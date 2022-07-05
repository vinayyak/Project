package com.vinni.controller;

import com.vinni.entity.Sales;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vinni.service.SalesService;

import java.util.List;

@RequestMapping("/sales")
@RestController
@AllArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @GetMapping("/all")
    public ResponseEntity<List<Sales>> findAll() {
        return new ResponseEntity<>(salesService.findAllSales(), HttpStatus.OK);
    }

    @PostMapping
    public String post() {
        return "Post";
    }
}
