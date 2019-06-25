package ru.stacy.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.stacy.dto.CarDto;
import ru.stacy.entity.Car;
import ru.stacy.entity.CarOwner;
import ru.stacy.entity.CarPark;
import ru.stacy.repository.CarOwnerRepository;
import ru.stacy.repository.CarParkRepository;
import ru.stacy.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarParkRepository carParkRepository;
    private final CarOwnerRepository carOwnerRepository;

    @Autowired
    public CarService(CarRepository carRepository, CarParkRepository carParkRepository, CarOwnerRepository carOwnerRepository) {
        this.carRepository = carRepository;
        this.carParkRepository = carParkRepository;
        this.carOwnerRepository = carOwnerRepository;
    }

    public Car createCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    public CarPark addCarParkToCar(Long carId, CarPark carPark) {
        Car car = carRepository.getOne(carId);
        carParkRepository.saveAndFlush(carPark);
        car.setCarPark(carPark);
        carRepository.saveAndFlush(car);
        return carPark;
    }

    public CarOwner addCarOwnerToCar(Long carId, CarOwner carOwner) {
        Car car = carRepository.getOne(carId);
        carOwnerRepository.saveAndFlush(carOwner);
        car.setCarOwner(carOwner);
        carRepository.saveAndFlush(car);
        return carOwner;
    }

    public List<CarDto> findAllCars() {
        List<Car> entities = carRepository.findAll();
        List<CarDto> dtos = new ArrayList<>();

        entities.forEach(entity -> {
            CarDto dto = new CarDto();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    public List<CarDto> findAllCarsByCarParkId(Long carParkId) {
        List<Car> entities = carRepository.findCarsByCarParkId(carParkId);
        List<CarDto> dtos = new ArrayList<>();

        entities.forEach(entity -> {
            CarDto dto = new CarDto();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    public List<CarDto> findAllCarsByCarOwnerId(Long carOwnerId) {
        List<Car> entities = carRepository.findCarsByCarOwnerId(carOwnerId);
        List<CarDto> dtos = new ArrayList<>();

        entities.forEach(entity -> {
            CarDto dto = new CarDto();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    public Optional<CarDto> findCarById(Long carId) {
        Assert.notNull(carId, "CarDto must not be null");

        Car entity = carRepository.getOne(carId);
        CarDto dto = new CarDto();

        BeanUtils.copyProperties(entity, dto);

        return Optional.of(dto);
    }

    public Car updateCar(Car carUpd) {
        Car car = carRepository.getOne(carUpd.getId());
        car.setName(carUpd.getName());
        car.setModel(carUpd.getModel());
        car.setDateOfManufacture(carUpd.getDateOfManufacture());
        car.setColor(carUpd.getColor());
        car.setNumber(carUpd.getNumber());
        return carRepository.saveAndFlush(car);
    }

    public Car updateCarById(Long carId, Car carUpd) {
        Car car = carRepository.getOne(carId);
        car.setName(carUpd.getName());
        car.setModel(carUpd.getModel());
        car.setDateOfManufacture(carUpd.getDateOfManufacture());
        car.setColor(carUpd.getColor());
        car.setNumber(carUpd.getNumber());
        return carRepository.saveAndFlush(car);
    }

    public String deleteCarById(Long carId) {
        carRepository.deleteById(carId);
        return "Car №" + carId + " was deleted";
    }
}
