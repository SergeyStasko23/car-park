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
@CrossOrigin
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // http://localhost:8080/api/cars
    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    // http://localhost:8080/api/cars/1/car-parks
    @PostMapping("/cars/{carId}/car-parks")
    public CarPark addCarParkToCar(@PathVariable Long carId, @RequestBody CarPark carPark) {
        return carService.addCarParkToCar(carId, carPark);
    }

    // http://localhost:8080/api/cars/1/car-owners
    @PostMapping("/cars/{carId}/car-owners")
    public CarOwner addCarOwnerToCar(@PathVariable Long carId, @RequestBody CarOwner carOwner) {
        return carService.addCarOwnerToCar(carId, carOwner);
    }

    // http://localhost:8080/api/cars
    @GetMapping("/cars")
    public List<CarDto> findAllCars() {
        return carService.findAllCars();
    }

    // http://localhost:8080/api/cars/1
    @GetMapping("/cars/{carId}")
    public Optional<CarDto> findCarById(@PathVariable Long carId) {
        return carService.findCarById(carId);
    }

    // http://localhost:8080/api/car-parks/1/cars
    @GetMapping("/car-parks/{carParkId}/cars")
    public List<CarDto> findAllCarsByCarParkId(@PathVariable Long carParkId) {
        return carService.findAllCarsByCarParkId(carParkId);
    }

    // http://localhost:8080/api/car-owners/1/cars
    @GetMapping("/car-owners/{carOwnerId}/cars")
    public List<CarDto> findAllCarsByCarOwnerId(@PathVariable Long carOwnerId) {
        return carService.findAllCarsByCarOwnerId(carOwnerId);
    }

    // http://localhost:8080/api/cars
    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car carUpd) {
        return carService.updateCar(carUpd);
    }

    // http://localhost:8080/api/cars/1
    @PutMapping("/cars/{carId}")
    public Car updateCarById(@PathVariable Long carId, @RequestBody Car carUpd) {
        return carService.updateCarById(carId, carUpd);
    }

    // http://localhost:8080/api/cars/1
    @DeleteMapping("/cars/{carId}")
    public String deleteCarById(@PathVariable Long carId) {
        return carService.deleteCarById(carId);
    }
}
