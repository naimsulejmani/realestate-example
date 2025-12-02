package com.example.realestate.mappers.impls;

import com.example.realestate.dtos.PropertyDto;
import com.example.realestate.entities.Property;
import com.example.realestate.mappers.PropertyMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertyMapperImpl implements PropertyMapper {
    @Override
    public PropertyDto toDto(Property property) {

        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setId(property.getId());
        propertyDto.setTitle(property.getTitle());
        propertyDto.setDescription(property.getDescription());
        propertyDto.setPrice(property.getPrice());
        propertyDto.setLocation(property.getLocation());
        propertyDto.setType(property.getType());
        propertyDto.setBedrooms(property.getBedrooms());
        propertyDto.setBathrooms(property.getBathrooms());
        propertyDto.setSquareMeters(property.getSquareMeters());
        propertyDto.setImage(property.getImage());
        propertyDto.setFloorNo(property.getFloorNo());
        propertyDto.setDoorNumber(property.getDoorNumber());
        propertyDto.setPassive(property.isPassive());
        propertyDto.setSold(property.isSold());

        return propertyDto;
    }

    @Override
    public Property toEntity(PropertyDto propertyDto) {
        Property property = new Property();
        property.setId(propertyDto.getId());
        property.setTitle(propertyDto.getTitle());
        property.setDescription(propertyDto.getDescription());
        property.setPrice(propertyDto.getPrice());
        property.setLocation(propertyDto.getLocation());
        property.setType(propertyDto.getType());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setBathrooms(propertyDto.getBathrooms());
        property.setSquareMeters(propertyDto.getSquareMeters());
        property.setImage(propertyDto.getImage());
        property.setFloorNo(propertyDto.getFloorNo());
        property.setDoorNumber(propertyDto.getDoorNumber());
        property.setPassive(propertyDto.isPassive());
        property.setSold(propertyDto.isSold());
        return property;
    }

    @Override
    public List<PropertyDto> toDtos(List<Property> properties) {
//
//        List<PropertyDto> dtos = new ArrayList<>();
//        for(Property prop: properties) {
//            PropertyDto dto = toDto(prop);
//            dtos.add(dto);
//        }

        return properties.stream().map(this::toDto).toList();
    }

    @Override
    public List<Property> toEntities(List<PropertyDto> propertyDtos) {
        return propertyDtos.stream().map(this::toEntity).toList();
    }
}
