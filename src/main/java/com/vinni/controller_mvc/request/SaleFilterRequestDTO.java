package com.vinni.controller_mvc.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SaleFilterRequestDTO {
    private String productName = null;
    private String segment = null;
    private String category = null;
    private String customerName = null;
    private String country = null;
    private String city = null;
    private String state = null;
    private String region = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderDateFrom;

    private LocalDate orderDateTo;
    private LocalDate shipDateFrom;
    private LocalDate shipDateTo;

}
