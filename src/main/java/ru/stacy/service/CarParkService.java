package ru.stacy.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.stacy.dto.CarParkDto;
import ru.stacy.entity.CarPark;
import ru.stacy.repository.CarParkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarParkService {
    private final CarParkRepository carParkRepository;

    @Autowired
    public CarParkService(CarParkRepository carParkRepository) {
        this.carParkRepository = carParkRepository;
    }

    public CarPark createCarPark(CarPark carPark) {
        return carParkRepository.saveAndFlush(carPark);
    }

    public List<CarPark> createCarParks(List<CarPark> carParks) {
        return carParkRepository.saveAll(carParks);
    }

    public List<CarParkDto> findAllCarParks() {
        List<CarPark> entities = carParkRepository.findAll();
        List<CarParkDto> dtos = new ArrayList<>();

        entities.forEach(entity -> {
            CarParkDto dto = new CarParkDto();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    public Optional<CarParkDto> findCarParkById(Long carParkId) {
        Assert.notNull(carParkId, "CarParkDto must not be null");

        CarPark entity = carParkRepository.getOne(carParkId);
        CarParkDto dto = new CarParkDto();

        BeanUtils.copyProperties(entity, dto);

        return Optional.of(dto);
    }

    public CarPark updateCarPark(CarPark carParkUpd) {
        CarPark carPark = carParkRepository.getOne(carParkUpd.getId());
        carPark.setName(carParkUpd.getName());
        return carParkRepository.saveAndFlush(carPark);
    }

    public CarPark updateCarParkById(Long carParkId, CarPark carParkUpd) {
        CarPark carPark = carParkRepository.getOne(carParkId);
        carPark.setName(carParkUpd.getName());
        return carParkRepository.saveAndFlush(carPark);
    }

    public String deleteCarParkById(Long carParkId) {
        carParkRepository.deleteById(carParkId);
        return "CarPark №" + carParkId + " was deleted";
    }
}
