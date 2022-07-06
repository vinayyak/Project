package com.vinni.controller;

import com.vinni.entity.Sales;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/all/product-name")
    public ResponseEntity<List<Sales>> findAllByProductName(
            @RequestParam("productName") String productName) {
        return new ResponseEntity<>(salesService.findAllSalesByProductName(productName), HttpStatus.OK);
    }

    @GetMapping("/all/category")
    public ResponseEntity<List<Sales>> findAllByCategory(
            @RequestParam("category") String category) {
        return new ResponseEntity<>(salesService.findAllSalesByCategory(category), HttpStatus.OK);
    }
}
