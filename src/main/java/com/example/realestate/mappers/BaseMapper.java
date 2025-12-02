package com.example.realestate.mappers;

import java.util.List;

public interface BaseMapper<TEntity, TDto> {
    TDto toDto(TEntity entity);
    TEntity toEntity(TDto dto);

    List<TDto> toDtos(List<TEntity> entities);
    List<TEntity> toEntities(List<TDto> dtos);
}
