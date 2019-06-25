package ru.stacy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stacy.dto.CarParkDto;
import ru.stacy.entity.CarPark;
import ru.stacy.service.CarParkService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class CarParkController {
    private final CarParkService carParkService;

    @Autowired
    public CarParkController(CarParkService carParkgService) {
        this.carParkService = carParkgService;
    }

    // http://localhost:8080/api/car-park
    @PostMapping("/car-park")
    public CarPark createCarPark(@RequestBody CarPark carPark) {
        return carParkService.createCarPark(carPark);
    }

    // http://localhost:8080/api/car-parks
    @PostMapping("/car-parks")
    public List<CarPark> createCarParks(@RequestBody List<CarPark> carParks) {
        return carParkService.createCarParks(carParks);
    }

    // http://localhost:8080/api/car-parks
    @GetMapping("/car-parks")
    public List<CarParkDto> findAllCarParks() {
        return carParkService.findAllCarParks();
    }

    // http://localhost:8080/api/car-parks/5
    @GetMapping("/car-parks/{carParkId}")
    public Optional<CarParkDto> findCarParkById(@PathVariable Long carParkId) {
        return carParkService.findCarParkById(carParkId);
    }

    // http://localhost:8080/api/cars/1/car-parks
    @GetMapping("/cars/{carId}/car-parks")
    public Optional<CarParkDto> findCarParkByCarId(@PathVariable Long carId) {
        return carParkService.findCarParkByCarId(carId);
    }

    // http://localhost:8080/api/car-parks
    @PutMapping("/car-parks")
    public CarPark updateCarPark(@RequestBody CarPark carParkUpd) {
        return carParkService.updateCarPark(carParkUpd);
    }

    // http://localhost:8080/api/car-parks/5
    @PutMapping("/car-parks/{carParkId}")
    public CarPark updateCarParkById(@PathVariable Long carParkId, @RequestBody CarPark carParkUpd) {
        return carParkService.updateCarParkById(carParkId, carParkUpd);
    }

    // http://localhost:8080/api/car-parks/5
    @DeleteMapping("/car-parks/{carParkId}")
    public String deleteCarParkById(@PathVariable Long carParkId) {
        return carParkService.deleteCarParkById(carParkId);
    }
}
