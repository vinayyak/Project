package com.vinni.entity;

import com.vinni.constant.Category;
import com.vinni.constant.Region;
import com.vinni.constant.Segment;
import com.vinni.constant.ShipMode;
import com.vinni.constant.converter.CategoryConverter;
import com.vinni.constant.converter.RegionConverter;
import com.vinni.constant.converter.SegmentConverter;
import com.vinni.constant.converter.ShipModeConverter;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "SALE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_NO", unique = true)
    private int RowID;

    @Column(name = "ORDER_NO")
    private String OrderID;

    @Column(name = "ORDER_DATE")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate orderDate;

    @Column(name = "SHIP_DATE")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate shipDate;

    @Column(name = "SHIP_MODE")
    @Convert(converter = ShipModeConverter.class)
    private ShipMode shipMode;

    @Column(name = "CUSTOMER_NO")
    private String customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "SEGMENT")
    @Convert(converter = SegmentConverter.class)
    private Segment segment;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    //    @Enumerated(EnumType.STRING)
    @Column(name = "REGION")
    @Convert(converter = RegionConverter.class)
    private Region region;

    @Column(name = "PRODUCT_NO")
    private String productID;

    //    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @Column(name = "SUB_CATEGORY")
    private String subCategory;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "SALES")
    private double Sales;


}
