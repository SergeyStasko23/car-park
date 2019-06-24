package ru.stacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stacy.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByCarParkId(Long carParkId);
    List<Car> findCarsByCarOwnerId(Long carOwnerId);
}
