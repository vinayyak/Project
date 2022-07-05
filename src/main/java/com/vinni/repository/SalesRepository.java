package com.vinni.repository;

import com.vinni.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findAllByCustomerName(String customerName);

    @Query("SELECT s FROM Sales s")
    List<Sales> findAllSales();
}
