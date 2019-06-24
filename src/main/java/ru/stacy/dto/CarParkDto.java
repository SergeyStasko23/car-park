package ru.stacy.dto;

public class CarParkDto {
    private Long id;
    private String name;

    public CarParkDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
