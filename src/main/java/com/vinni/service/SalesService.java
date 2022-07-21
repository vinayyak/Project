package com.vinni.service;

import com.vinni.constant.Category;
import com.vinni.controller_mvc.request.SaleFilterRequestDTO;
import com.vinni.entity.Sales;

import java.util.*;

public interface SalesService {
    List<Sales> findAllSales();

    List<Sales> findAllSalesByCategory(Category category);

    Sales getSaleByID(long saleID);

    List<Sales> findAllSalesByProductName(String productName);

    List<Sales> findAllSalesByCategory(String category);

    /*New*/
    List<Sales> findAllSalesByRegion(String region);

    List<Sales> findAllSalesBySegment(String segment);

    List<Sales> findAllSalesByCustomerName(String customerName);

    List<Sales> findAllSalesByCity(String city);

    List<Sales> findSalesByFiltering(SaleFilterRequestDTO filter);

    void coverDB();



}


