package ru.stacy.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.stacy.dto.CarDto;
import ru.stacy.dto.CarOwnerDto;
import ru.stacy.entity.Car;
import ru.stacy.entity.CarOwner;
import ru.stacy.repository.CarOwnerRepository;
import ru.stacy.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarOwnerService {
    private final CarOwnerRepository carOwnerRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarOwnerService(CarOwnerRepository carOwnerRepository, CarRepository carRepository) {
        this.carOwnerRepository = carOwnerRepository;
        this.carRepository = carRepository;
    }

    public CarOwner createCarOwner(CarOwner carOwner) {
        return carOwnerRepository.saveAndFlush(carOwner);
    }

    public List<CarOwnerDto> findAllCarOwners() {
        List<CarOwner> entities = carOwnerRepository.findAll();
        List<CarOwnerDto> dtos = new ArrayList<>();

        entities.forEach(entity -> {
            CarOwnerDto dto = new CarOwnerDto();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    public Optional<CarOwnerDto> findCarOwnerById(Long carOwnerId) {
        Assert.notNull(carOwnerId, "CarOwnerDto must not be null");

        CarOwner entity = carOwnerRepository.getOne(carOwnerId);
        CarOwnerDto dto = new CarOwnerDto();

        BeanUtils.copyProperties(entity, dto);

        return Optional.of(dto);
    }

    public Optional<CarOwnerDto> findCarOwnerByCarId(Long carId) {
        Car car = carRepository.getOne(carId);

        CarOwner entity = car.getCarOwner();
        CarOwnerDto dto = new CarOwnerDto();

        BeanUtils.copyProperties(entity, dto);

        return Optional.of(dto);
    }

    public CarOwner updateCarOwner(CarOwner carOwnerUpd) {
        CarOwner carOwner = carOwnerRepository.getOne(carOwnerUpd.getId());
        carOwner.setFirstname(carOwnerUpd.getFirstname());
        carOwner.setSurname(carOwnerUpd.getSurname());
        carOwner.setPatronymic(carOwnerUpd.getPatronymic());
        carOwner.setDateOfBirth(carOwnerUpd.getDateOfBirth());
        return carOwnerRepository.saveAndFlush(carOwner);
    }

    public CarOwner updateCarOwnerById(Long carOwnerId, CarOwner carOwnerUpd) {
        CarOwner carOwner = carOwnerRepository.getOne(carOwnerId);
        carOwner.setFirstname(carOwnerUpd.getFirstname());
        carOwner.setSurname(carOwnerUpd.getSurname());
        carOwner.setPatronymic(carOwnerUpd.getPatronymic());
        carOwner.setDateOfBirth(carOwnerUpd.getDateOfBirth());
        return carOwnerRepository.saveAndFlush(carOwner);
    }

    public String deleteCarOwnerById(Long carOwnerId) {
        carOwnerRepository.deleteById(carOwnerId);
        return "CarOwner №" + carOwnerId + " was deleted";
    }
}
