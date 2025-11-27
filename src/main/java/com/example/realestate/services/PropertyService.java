package com.example.realestate.services;

import com.example.realestate.models.Property;
import tools.jackson.databind.annotation.JsonAppend;

import java.util.List;
import java.util.UUID;

public interface PropertyService {

    public List<Property> findAll();

    public Property findById(UUID id);

    public Property add(Property property);

    public Property modify(UUID id, Property property);

    public void deleteById(UUID id);
}
