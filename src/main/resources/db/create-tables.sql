CREATE TABLE car_park (
  car_park_id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255)
);

CREATE TABLE car (
  car_id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255),
  model VARCHAR(255),
  date_of_manufacture TIMESTAMP,
  color VARCHAR,
  number VARCHAR,
  car_park_id BIGINT,
  car_owner_id BIGINT
);

CREATE TABLE car_owner (
  car_owner_id SERIAL PRIMARY KEY NOT NULL,
  firstname VARCHAR,
  surname VARCHAR,
  patronymic VARCHAR,
  date_of_birth TIMESTAMP
);

ALTER TABLE car ADD CONSTRAINT car_park_car_park_id_fkey FOREIGN KEY (car_park_id) REFERENCES car_park (car_park_id);
ALTER TABLE car ADD CONSTRAINT car_owner_car_owner_id_fkey FOREIGN KEY (car_owner_id) REFERENCES car_owner (car_owner_id);