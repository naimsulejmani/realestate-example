package com.example.realestate.services.impls;

import com.example.realestate.dtos.PropertyDto;
import com.example.realestate.entities.Property;
import com.example.realestate.mappers.PropertyMapper;
import com.example.realestate.repositories.PropertyRepository;
import com.example.realestate.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.realestate.helpers.Helper.isNullOrBlank;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Override
    public List<PropertyDto> findAll() {
        List<Property> properties = propertyRepository.findAll();

        return propertyMapper.toDtos(properties);
    }

    @Override
    public PropertyDto findById(UUID id) {
        Property property = propertyRepository.findById(id).orElse(null);

        return propertyMapper.toDto(property);
    }

    @Override
    public PropertyDto add(PropertyDto property) {
        if (property.getId() != null) {
            var existProperty = propertyRepository.existsById(property.getId());
            if (existProperty) {
                throw new RuntimeException("Property already exists");
            }
        }
        Property propertyEntity = propertyMapper.toEntity(property);
        propertyRepository.save(propertyEntity);
        return propertyMapper.toDto(propertyEntity);
    }

    @Override
    public PropertyDto modify(UUID id, PropertyDto property) {
        var existsProperty = propertyRepository.existsById(id);
        if (!existsProperty) {
            throw new RuntimeException("Property does not exists");
        }

        Property propertyEntity = propertyMapper.toEntity(property);
        propertyEntity.setId(id);
        propertyRepository.save(propertyEntity);
        return propertyMapper.toDto(propertyEntity);
    }

    @Override
    public void deleteById(UUID id) {

        var property = propertyRepository.findById(id);
        if (property == null) {
            return;
        }
        if (property.get().isSold() == true) {
            throw new RuntimeException("Cannot delete sold property");
        }
        propertyRepository.deleteById(id);
    }

    @Override
    public List<PropertyDto> findAllBy(String filterType, String filterText) {
        List<Property> properties = null;
        //check if is null or empty for both cases
        if (isNullOrBlank(filterType) && isNullOrBlank(filterText)) {
            properties = propertyRepository.findAll();
        } else if (!isNullOrBlank(filterType) && isNullOrBlank(filterText)) {
            properties = propertyRepository.findAllByType(filterType);
        } else if (isNullOrBlank(filterType) && !isNullOrBlank(filterText)) {
            properties = propertyRepository.findAllByTitleContainsOrLocationContainsOrDescriptionContains(filterText, filterText, filterText);
        } else {
            properties = propertyRepository.findAllByTypeAndTitleContainsOrLocationContainsOrDescriptionContains(filterType, filterText, filterText, filterText);
        }

        return propertyMapper.toDtos(properties);
    }
}
