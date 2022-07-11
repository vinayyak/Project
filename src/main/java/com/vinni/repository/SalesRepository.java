package com.vinni.repository;

import com.vinni.constant.Category;
import com.vinni.constant.Region;
import com.vinni.constant.Segment;
import com.vinni.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Query("SELECT s FROM Sales s " +
            "WHERE (:productName IS NULL OR (s.productName like CONCAT('%', :productName, '%'))) " +
            "AND (:segment IS NULL OR (s.segment = :segment)) " +
            "AND (:category IS NULL OR (s.category = :category)) " +
            "AND (:customerName IS NULL OR (s.customerName like CONCAT('%', :customerName, '%'))) " +
            "AND (:country IS NULL OR (s.country = :country))" +
            "AND (:city IS NULL OR (s.city = :city))" +
            "AND (:state IS NULL OR (s.state = :state))" +
            "AND (:region IS NULL OR (s.region = :region)) " +
            "AND ( (:orderDateFrom IS NULL OR s.orderDate >= :orderDateFrom)" +
            "    AND (:orderDateTo IS NULL OR s.orderDate < :orderDateTo) )" +
            "AND ( (:shipDateFrom IS NULL OR s.shipDate >= :shipDateFrom)" +
            "    AND (:shipDateTo IS NULL OR s.shipDate < :shipDateTo) )")
    List<Sales> findSalesByFiltering(@Param("productName") String productName,
                                     @Param("segment") Segment segment,
                                     @Param("category") Category category,
                                     @Param("customerName") String customerName,
                                     @Param("country") String country,
                                     @Param("city") String city,
                                     @Param("state") String state,
                                     @Param("region") Region region,
                                     @Param("orderDateFrom")LocalDate orderDateFrom,
                                     @Param("orderDateTo")LocalDate orderDateTo,
                                     @Param("shipDateFrom")LocalDate shipDateFrom,
                                     @Param("shipDateTo")LocalDate shipDateTo
                                     )

            ;


}
