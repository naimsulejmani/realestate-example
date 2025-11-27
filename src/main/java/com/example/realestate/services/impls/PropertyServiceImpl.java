package com.example.realestate.services.impls;

import com.example.realestate.models.Property;
import com.example.realestate.repositories.PropertyRepository;
import com.example.realestate.services.PropertyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

//    public PropertyServiceImpl(PropertyRepository propertyRepository) {
//        this.propertyRepository = propertyRepository;
//    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Property findById(UUID id) {
        //direct method addrressin, direct constructor addressing
        return propertyRepository.findById(id).orElse(null);
    }

    @Override
    public Property add(Property property) {
        var existProperty = propertyRepository.existsById(property.getId());
        if (existProperty) {
            throw new RuntimeException("Property already exists");
        }

        return propertyRepository.save(property);
    }

    @Override
    public Property modify(UUID id, Property property) {
        var existsProperty = propertyRepository.existsById(id);
        if (!existsProperty) {
            throw new RuntimeException("Property does not exists");
        }
        return propertyRepository.save(property);
    }

    @Override
    public void deleteById(UUID id) {
        propertyRepository.deleteById(id);
    }
}
