package ru.stacy.dto.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.stacy.dto.CarDto;
import ru.stacy.entity.Car;

@Service
public class CarConverter {
    public Car toEntity(CarDto dto) {
        Car entity = new Car();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public CarDto toDto(Car entity) {
        CarDto dto = new CarDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
