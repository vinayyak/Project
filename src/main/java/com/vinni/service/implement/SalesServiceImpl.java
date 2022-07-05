package com.vinni.service.implement;

import com.vinni.constant.Category;
import com.vinni.entity.Sales;
import com.vinni.repository.SalesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vinni.service.SalesService;


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
}
