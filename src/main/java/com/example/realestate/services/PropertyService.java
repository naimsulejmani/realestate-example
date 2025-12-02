package com.example.realestate.services;

import com.example.realestate.dtos.PropertyDto;

import java.util.List;
import java.util.UUID;

public interface PropertyService {

    public List<PropertyDto> findAll();

    public PropertyDto findById(UUID id);

    public PropertyDto add(PropertyDto property);

    public PropertyDto modify(UUID id, PropertyDto property);

    public void deleteById(UUID id);

    List<PropertyDto> findAllBy(String filterType, String filterText);
}
