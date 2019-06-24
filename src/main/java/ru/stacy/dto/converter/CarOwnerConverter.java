package ru.stacy.dto.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.stacy.dto.CarOwnerDto;
import ru.stacy.entity.CarOwner;

@Service
public class CarOwnerConverter {
    public CarOwner toEntity(CarOwnerDto dto) {
        CarOwner entity = new CarOwner();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public CarOwnerDto toDto(CarOwner entity) {
        CarOwnerDto dto = new CarOwnerDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
