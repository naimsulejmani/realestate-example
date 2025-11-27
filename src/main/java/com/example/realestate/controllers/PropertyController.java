package com.example.realestate.controllers;

import com.example.realestate.models.Property;
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

    @GetMapping
    public String listProperties(Model model) {
        model.addAttribute("properties", propertyService.findAll());
        return "properties/list";
    }

    @GetMapping("/new")
    public String newProperty(Model model) {
        model.addAttribute("property", new Property());
        return "properties/new";
    }

    @PostMapping("/new")
    public String saveProperty(@ModelAttribute Property property) {
        propertyService.add(property);
        return "redirect:/properties";
    }

    @GetMapping("/edit/{id}")
    public String getEditProperty(@PathVariable UUID id,Model model ) {
        model.addAttribute("property", propertyService.findById(id));
        return "properties/edit";
    }

}
