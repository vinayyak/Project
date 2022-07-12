package com.vinni.controller_mvc;

import com.vinni.controller_mvc.request.SaleFilterRequestDTO;
import com.vinni.service.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
@AllArgsConstructor
public class MVCSalesController {

    private final SalesService salesService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("saleList", salesService.findAllSalesByProductName("phone"));
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!model.containsAttribute("saleList")) {
            model.addAttribute("saleList", salesService.findAllSales());
        }

        if (!model.containsAttribute("saleFilterRequestDTO")) {
            model.addAttribute("saleFilterRequestDTO", new SaleFilterRequestDTO());
        }
        return "home";
    }

    @PostMapping(value = "/filter")
    public String filter(Model model, @ModelAttribute("saleFilterRequestDTO") SaleFilterRequestDTO saleFilterRequestDTO,
                         @RequestParam(value = "action") String action) {
        if ("filter".equalsIgnoreCase(action))
            model.addAttribute("saleList", salesService.findSalesByFiltering(saleFilterRequestDTO));
        else
            model.addAttribute("saleList", salesService.findAllSales());
        return "home";
    }
}