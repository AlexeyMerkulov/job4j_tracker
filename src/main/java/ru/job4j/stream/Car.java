package ru.job4j.stream;

public class Car {
    private String brand;
    private String model;
    private String colour;
    private String bodyType;
    private String wheelDrive;
    private int yearOfProduction;
    private int horsePower;

    static class Builder {
        private String brand;
        private String model;
        private String colour;
        private String bodyType;
        private String wheelDrive;
        private int yearOfProduction;
        private int horsePower;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColour(String colour) {
            this.colour = colour;
            return this;
        }

        Builder buildBodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        Builder buildWheelDrive(String wheelDrive) {
            this.wheelDrive = wheelDrive;
            return this;
        }

        Builder buildYearOfProduction(int yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        Builder buildHorsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.colour = colour;
            car.bodyType = bodyType;
            car.wheelDrive = wheelDrive;
            car.yearOfProduction = yearOfProduction;
            car.horsePower = horsePower;
            return car;
        }
    }
}
