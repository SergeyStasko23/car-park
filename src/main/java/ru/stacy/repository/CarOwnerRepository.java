package ru.stacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stacy.entity.CarOwner;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {

}
