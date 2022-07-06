package com.vinni.service;

import com.vinni.constant.Category;
import com.vinni.entity.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> findAllSales();

    List<Sales> findAllSalesByCategory(Category category);

    Sales getSaleByID(long saleID);

    List<Sales> findAllSalesByProductName(String productName);
    List<Sales> findAllSalesByCategory(String category);
}
