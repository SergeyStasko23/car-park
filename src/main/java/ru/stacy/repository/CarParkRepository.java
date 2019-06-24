package ru.stacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stacy.entity.CarPark;

public interface CarParkRepository extends JpaRepository<CarPark, Long> {

}
