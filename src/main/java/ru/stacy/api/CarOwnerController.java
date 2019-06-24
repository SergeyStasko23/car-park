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
public class CarOwnerController {
    private final CarOwnerService carOwnerService;

    @Autowired
    public CarOwnerController(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    @PostMapping("/car-owners")
    public CarOwner createCarOwner(@RequestBody CarOwner carOwner) {
        return carOwnerService.createCarOwner(carOwner);
    }

    @GetMapping("/car-owners")
    public List<CarOwnerDto> findAllCarOwners() {
        return carOwnerService.findAllCarOwners();
    }

    @GetMapping("/car-owners/{carOwnerId}")
    public Optional<CarOwnerDto> findCarOwnerById(@PathVariable Long carOwnerId) {
        return carOwnerService.findCarOwnerById(carOwnerId);
    }

    @PutMapping("/car-owners")
    public CarOwner updateCarOwner(@RequestBody CarOwner carOwnerUpd) {
        return carOwnerService.updateCarOwner(carOwnerUpd);
    }

    @PutMapping("/car-owners/{carOwnerId}")
    public CarOwner updateCarOwnerById(@PathVariable Long carOwnerId, @RequestBody CarOwner carOwnerUpd) {
        return carOwnerService.updateCarOwnerById(carOwnerId, carOwnerUpd);
    }

    @DeleteMapping("/car-parks/{carOwnerId}")
    public String deleteCarOwnerById(@PathVariable Long carOwnerId) {
        return carOwnerService.deleteCarOwnerById(carOwnerId);
    }
}
