package ru.stacy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stacy.dto.CarDto;
import ru.stacy.entity.Car;
import ru.stacy.entity.CarOwner;
import ru.stacy.entity.CarPark;
import ru.stacy.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PostMapping("/cars/{carId}/car-parks")
    public CarPark addCarParkToCar(@PathVariable Long carId, @RequestBody CarPark carPark) {
        return carService.addCarParkToCar(carId, carPark);
    }

    @PostMapping("/cars/{carId}/car-owners")
    public CarOwner addCarOwnerToCar(@PathVariable Long carId, @RequestBody CarOwner carOwner) {
        return carService.addCarOwnerToCar(carId, carOwner);
    }

    @GetMapping("/cars")
    public List<CarDto> findAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/cars/{carId}")
    public Optional<CarDto> findCarById(@PathVariable Long carId) {
        return carService.findCarById(carId);
    }

    @GetMapping("/car-parks/{carParkId}/cars")
    public List<CarDto> findAllCarsByCarParkId(@PathVariable Long carParkId) {
        return carService.findAllCarsByCarParkId(carParkId);
    }

    @GetMapping("/car-owners/{carOwnerId}/cars")
    public List<CarDto> findAllCarsByCarOwnerId(@PathVariable Long carOwnerId) {
        return carService.findAllCarsByCarOwnerId(carOwnerId);
    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car carUpd) {
        return carService.updateCar(carUpd);
    }

    @PutMapping("/cars/{carId}")
    public Car updateCarById(@PathVariable Long carId, @RequestBody Car carUpd) {
        return carService.updateCarById(carId, carUpd);
    }

    @DeleteMapping("/cars/{carId}")
    public String deleteCarById(@PathVariable Long carId) {
        return carService.deleteCarById(carId);
    }
}
