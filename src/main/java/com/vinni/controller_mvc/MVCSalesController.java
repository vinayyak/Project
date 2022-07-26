package com.vinni.controller_mvc;

import com.vinni.controller_mvc.request.SaleFilterRequestDTO;
import com.vinni.entity.City;
import com.vinni.entity.State;
import com.vinni.service.CityService;
import com.vinni.service.SalesService;
import com.vinni.service.StateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/")
@Controller
@AllArgsConstructor
@Slf4j
public class MVCSalesController {

    private final SalesService salesService;
    private final StateService stateService;

    private final CityService cityService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("saleList", salesService.findAllSalesByProductName("phone"));
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        // States
        validateStates(model);
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

    private void validateStates(Model model){
        List<State> stateList = stateService.retrieveAllStates();
        for(State state : stateList){
            log.info("==== State: " + state.getStateName() + " - " +
                    state.getCities().stream().map(City::getCityName).collect(Collectors.joining(", ")));
        }
        model.addAttribute("stateList", stateList);

        //TODO: Add the states and cities to the Model Map<String, Set<String>>
        // User this method in wherever places that needs the relationship for filtering
    }




    }
