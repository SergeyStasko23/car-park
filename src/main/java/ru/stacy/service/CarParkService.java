package ru.stacy.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.stacy.dto.CarParkDto;
import ru.stacy.entity.Car;
import ru.stacy.entity.CarPark;
import ru.stacy.repository.CarParkRepository;
import ru.stacy.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarParkService {
    private final CarParkRepository carParkRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarParkService(CarParkRepository carParkRepository, CarRepository carRepository) {
        this.carParkRepository = carParkRepository;
        this.carRepository = carRepository;
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

    public Optional<CarParkDto> findCarParkByCarId(Long carId) {
        Car car = carRepository.getOne(carId);

        CarPark entity = car.getCarPark();
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
