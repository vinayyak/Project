package com.vinni.controller;

import com.vinni.controller_mvc.request.SaleFilterRequestDTO;
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
            @RequestParam(name = "productName", required = false) String productName) {
        return new ResponseEntity<>(salesService.findAllSalesByProductName(productName), HttpStatus.OK);
    }

    @GetMapping("/all/category")
    public ResponseEntity<List<Sales>> findAllByCategory(
            @RequestParam(name = "category", required = false) String category) {
        return new ResponseEntity<>(salesService.findAllSalesByCategory(category), HttpStatus.OK);

    }

    /*New*/
    @GetMapping("/all/region")
    public ResponseEntity<List<Sales>> findAllByRegion(
            @RequestParam("region") String region) {
        return new ResponseEntity<>(salesService.findAllSalesByRegion(region), HttpStatus.OK);
    }

    @GetMapping("/all/segment")
    public ResponseEntity<List<Sales>> findAllBySegment(
            @RequestParam("segment") String segment) {
        return new ResponseEntity<>(salesService.findAllSalesBySegment(segment), HttpStatus.OK);
    }

    @GetMapping("/all/customer-name")
    public ResponseEntity<List<Sales>> findAllByCustomerName(
            @RequestParam("customerName") String customerName) {
        return new ResponseEntity<>(salesService.findAllSalesByCustomerName(customerName), HttpStatus.OK);
    }

    @GetMapping("/all/city")
    public ResponseEntity<List<Sales>> findAllByCity(
            @RequestParam("city") String city) {
        return new ResponseEntity<>(salesService.findAllSalesByCity(city), HttpStatus.OK);
    }

    @PostMapping("/all/filter")
    public ResponseEntity<List<Sales>> findAllByFilter(
            @RequestBody SaleFilterRequestDTO filterRequestDTO) {
        return new ResponseEntity<>(salesService.findSalesByFiltering(filterRequestDTO), HttpStatus.OK);
    }

//    @Deprecated
//    @GetMapping("/all/cover")
//    public void cover() {
//        salesService.coverDB();
//    }

}

