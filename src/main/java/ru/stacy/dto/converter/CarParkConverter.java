package ru.stacy.dto.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.stacy.dto.CarParkDto;
import ru.stacy.entity.CarPark;

@Service
public class CarParkConverter {
    public CarPark toEntity(CarParkDto dto) {
        CarPark entity = new CarPark();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public CarParkDto toDto(CarPark entity) {
        CarParkDto dto = new CarParkDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
