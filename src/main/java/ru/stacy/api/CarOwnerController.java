package ru.stacy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stacy.dto.CarOwnerDto;
import ru.stacy.entity.CarOwner;
import ru.stacy.service.CarOwnerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarOwnerController {
    private final CarOwnerService carOwnerService;

    @Autowired
    public CarOwnerController(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    // http://localhost:8080/api/car-owners
    @PostMapping("/car-owners")
    public CarOwner createCarOwner(@RequestBody CarOwner carOwner) {
        return carOwnerService.createCarOwner(carOwner);
    }

    // http://localhost:8080/api/car-owners
    @GetMapping("/car-owners")
    public List<CarOwnerDto> findAllCarOwners() {
        return carOwnerService.findAllCarOwners();
    }

    // http://localhost:8080/api/car-owners/1
    @GetMapping("/car-owners/{carOwnerId}")
    public Optional<CarOwnerDto> findCarOwnerById(@PathVariable Long carOwnerId) {
        return carOwnerService.findCarOwnerById(carOwnerId);
    }

    // http://localhost:8080/api/cars/1/car-owners
    @GetMapping("/cars/{carId}/car-owners")
    public Optional<CarOwnerDto> findCarOwnerByCarId(@PathVariable Long carId) {
        return carOwnerService.findCarOwnerByCarId(carId);
    }

    // http://localhost:8080/api/car-owners
    @PutMapping("/car-owners")
    public CarOwner updateCarOwner(@RequestBody CarOwner carOwnerUpd) {
        return carOwnerService.updateCarOwner(carOwnerUpd);
    }


    // http://localhost:8080/api/car-owners/1
    @PutMapping("/car-owners/{carOwnerId}")
    public CarOwner updateCarOwnerById(@PathVariable Long carOwnerId, @RequestBody CarOwner carOwnerUpd) {
        return carOwnerService.updateCarOwnerById(carOwnerId, carOwnerUpd);
    }

    // http://localhost:8080/api/car-owners/1
    @DeleteMapping("/car-owners/{carOwnerId}")
    public String deleteCarOwnerById(@PathVariable Long carOwnerId) {
        return carOwnerService.deleteCarOwnerById(carOwnerId);
    }
}
