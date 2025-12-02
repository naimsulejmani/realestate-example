package com.example.realestate.controllers;

import com.example.realestate.dtos.PropertyDto;
import com.example.realestate.entities.Property;
import com.example.realestate.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    //http://localhost:8080/properties?filterText=naimi&filterType=APARTMENT
    @GetMapping
    public String listProperties(@RequestParam(required = false) String filterText,
                                 @RequestParam(required = false) String filterType,
                                 Model model) {
        model.addAttribute("properties", propertyService.findAllBy(filterType, filterText));
        model.addAttribute("filterType", filterType);
        model.addAttribute("filterText", filterText);
        return "properties/list";
    }

    @GetMapping("/new")
    public String newProperty(Model model) {
        model.addAttribute("property", new PropertyDto());
        return "properties/new";
    }

    @PostMapping("/new")
    public String saveProperty(@ModelAttribute PropertyDto property) {
        propertyService.add(property);
        return "redirect:/properties";
    }

    @GetMapping("/edit/{id}")
    public String getEditProperty(@PathVariable UUID id, Model model) {
        model.addAttribute("property", propertyService.findById(id));
        return "properties/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProperty(@PathVariable UUID id, @ModelAttribute PropertyDto property) {
        propertyService.modify(id, property);
        return "redirect:/properties";
    }

    @GetMapping("/view/{id}")
    public String viewProperty(@PathVariable UUID id, Model model) {
        var property = propertyService.findById(id);
        model.addAttribute("property", property);
        model.addAttribute("page", "VIEW");
        return "properties/view";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteProperty(@PathVariable UUID id, Model model) {
        var property = propertyService.findById(id);
        model.addAttribute("property", property);
        model.addAttribute("page", "DELETE");
        return "properties/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteProperty(@PathVariable UUID id) {
        propertyService.deleteById(id);
        return "redirect:/properties"; // kjo e nderron URL-in e browserit prej ku je ku don me shku
    }


}
