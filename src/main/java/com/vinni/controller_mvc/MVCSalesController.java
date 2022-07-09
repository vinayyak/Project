package com.vinni.controller_mvc;

import com.vinni.service.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("saleList", salesService.findAllSalesByProductName("phone"));
        return "home";
    }

    @GetMapping("/vinni")
    public String helloVinni(Model model) {
        return "vinni";
    }

    @GetMapping("/company/hcl")
    public String helloHcl(Model model) {
        return "company/hcl";
    }

    /*New*/

    @GetMapping("/city")
    public String city(Model model) {
        model.addAttribute("saleList", salesService.findAllSalesByCity("Los Angeles"));
        return "city";
    }
}
