package com.vinni.repository;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.vinni.constant.Category;
import com.vinni.constant.Region;
import com.vinni.constant.Segment;
import com.vinni.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

//    List<Sales> findAllByCustomerName(String customerName);

    @Query("SELECT s FROM Sales s")
    List<Sales> findAllSales();

    @Query("SELECT s FROM Sales s WHERE s.productName like %:productName% ")
    List<Sales> findAllByProductName(@Param("productName") String productName);

    @Query("SELECT s FROM Sales s WHERE s.category = :category ")
    List<Sales> findAllByCategory(@Param("category") Category category);
    /*New*/
    @Query("SELECT s FROM Sales s WHERE s.region = :region ")
    List<Sales> findAllByRegion(@Param("region") Region region);

    @Query("SELECT s FROM Sales s WHERE s.segment = :segment ")
    List<Sales> findAllBySegment(@Param("segment") Segment segment);

    @Query("SELECT s FROM Sales s WHERE s.customerName like %:customerName% ")
    List<Sales> findAllByCustomerName(@Param("customerName") String customerName);

    @Query("SELECT s FROM Sales s WHERE s.city like %:city% ")
    List<Sales> findAllByCity(@Param("city") String city);





}
