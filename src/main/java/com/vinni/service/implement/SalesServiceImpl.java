package com.vinni.service.implement;

import antlr.StringUtils;
import com.vinni.constant.Category;
import com.vinni.constant.Region;
import com.vinni.constant.Segment;
import com.vinni.controller_mvc.request.SaleFilterRequestDTO;
import com.vinni.entity.Sales;
import com.vinni.repository.SalesRepository;
import com.vinni.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
@Service
@Slf4j
@AllArgsConstructor
public class SalesServiceImpl implements SalesService {
    private final SalesRepository salesRepository;

    @Override
    public List<Sales> findAllSales() {
        log.info("Starting to find all the Sales");
        List<Sales> result = salesRepository.findAllSales();
        log.info("Finished finding all the Sales, Total record(s): {}", result.size());
        return result;
    }

    @Override
    public List<Sales> findAllSalesByCategory(Category category) {
        return null;
    }

    @Override
    public Sales getSaleByID(long saleID) {
        return null;
    }

    @Override
    public List<Sales> findAllSalesByProductName(String productName) {
        log.info("Starting to find all the sales by Product Name");
        List<Sales> result = salesRepository.findAllByProductName(productName);
        log.info("Finished finding all the Sales, Total record(s): {}", result.size());
        return result;
    }


    @Override
    public List<Sales> findAllSalesByCategory(String category) {
        Category filteringCategory = Category.findByString(category);
        if (filteringCategory == null) {
            throw new RuntimeException("Category is invalid!");
        } else {
            log.info("Starting to find all the sales by Category");
            List<Sales> result = salesRepository.findAllByCategory(filteringCategory);
            log.info("Finished finding all the Category, Total record(s): {}", result.size());
            return result;


        }
    }

    /*New*/
    @Override
    public List<Sales> findAllSalesByRegion(String region) {
        Region filteringRegion = Region.findByString(region);
        if (filteringRegion == null) {
            throw new RuntimeException("Region is invalid!");
        } else {
            log.info("Starting to find all the sales by Region");
            List<Sales> result = salesRepository.findAllByRegion(filteringRegion);
            log.info("Finished finding all the Regions, Total record(s): {}", result.size());
            return result;


        }
    }

    @Override
    public List<Sales> findAllSalesBySegment(String segment) {
        Segment filteringSegment = Segment.findByString(segment);
        if (filteringSegment == null) {
            throw new RuntimeException("Segment is invalid!");
        } else {
            log.info("Starting to find all the sales by Segment");
            List<Sales> result = salesRepository.findAllBySegment(filteringSegment);
            log.info("Finished finding all the Segments, Total record(s): {}", result.size());
            return result;


        }
    }

    @Override
    public List<Sales> findAllSalesByCustomerName(String customerName) {
        log.info("Starting to find all the sales by Customer Name");
        List<Sales> result = salesRepository.findAllByCustomerName(customerName);
        log.info("Finished finding all the Sales, Total record(s): {}", result.size());
        return result;
    }

    @Override
    public List<Sales> findAllSalesByCity(String city) {
        log.info("Starting to find all the sales by City");
        List<Sales> result = salesRepository.findAllByCity(city);
        log.info("Finished finding all the Sales, Total record(s): {}", result.size());
        return result;
    }

    @Override
    public List<Sales> findSalesByFiltering(SaleFilterRequestDTO filter) {
        log.info("Starting to filter all the Sales with criteria: Product name: {}, Segment: {}, Category: {}, " +
                        "Customer name: {}, Country : {}, City: {}, State: {}, Region: {}, Order Date: ({} - {})," +
                        " Ship Date: ({} - {})",
                filter.getProductName(),
                filter.getSegment(),
                filter.getCategory(),
                filter.getCustomerName(),
                filter.getCountry(),
                filter.getCity(),
                filter.getState(),
                filter.getRegion(),
                filter.getOrderDateFrom(),
                filter.getOrderDateTo(),
                filter.getShipDateFrom(),
                filter.getShipDateTo());
        // Validate the Enums
        Segment filteringSegment = Segment.findByString(filter.getSegment());
        Category filteringCategory = Category.findByString(filter.getCategory());
        Region filteringRegion = Region.findByString(filter.getRegion());

        // TODO: Filter by CustomerName, Country, City, State, Region, Order Date, ShipDate
        List<Sales> result = salesRepository.findSalesByFiltering(
                Strings.isBlank(filter.getProductName()) ? null : filter.getProductName(),
                filteringSegment,
                filteringCategory,
                Strings.isBlank(filter.getCustomerName()) ? null : filter.getCustomerName(),
                Strings.isBlank(filter.getCountry()) ? null : filter.getCountry(),
                Strings.isBlank(filter.getCity()) ? null : filter.getCity(),
                Strings.isBlank(filter.getState()) ? null : filter.getState(),
                filteringRegion,
                filter.getOrderDateFrom(),
                filter.getOrderDateTo(),
                filter.getShipDateFrom(),
                filter.getShipDateTo());
        log.info("Finished filtering all the Sales, Total record(s): {}", result.size());
        return result;
    }

    @Override
    @Transactional
    public void coverDB() {
        List<Sales> allSales = salesRepository.findAllSales();
        LocalDate startDate = LocalDate.of(2020, Month.JANUARY, 1);
        int plusDate = 0;
        for (Sales s : allSales) {
            plusDate += 5;
            s.setOrderDate(startDate.plusDays(plusDate));
            s.setShipDate(startDate.plusDays(plusDate + 6));
        }
        salesRepository.saveAll(allSales);
        log.info("Done Cover DB");
    }


}
