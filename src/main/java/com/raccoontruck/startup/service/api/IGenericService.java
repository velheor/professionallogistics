package com.raccoontruck.startup.service.api;

import java.util.List;

public interface IGenericService<DTO, Entity> {
    List<DTO> findAll();

    DTO findById(Long id);

    DTO update(DTO dto);

    void delete(Long id);

    DTO convertToDTO(Entity entity);

    Entity convertFromDTO(DTO dto);

    List<DTO> convertToDTO(List<Entity> entitys);

    List<Entity> convertFromDTO(List<DTO> dtos);
}