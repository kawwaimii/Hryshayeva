import java.util.ArrayList;
import java.util.List;

// Основной класс
public class Main {

    // Базовый класс Автомобиль
    static class Car {
        private String brand;
        private String model;
        private int year;
        private double price;

        public Car(String brand, String model, int year, double price) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return brand + " " + model + " (" + year + ") - $" + price;
        }
    }

    // Подкласс Легковой автомобиль
    static class PassengerCar extends Car {
        public PassengerCar(String brand, String model, int year, double price) {
            super(brand, model, year, price);
        }
    }

    // Подкласс Эконом класс
    static class EconomyCar extends PassengerCar {
        public EconomyCar(String brand, String model, int year, double price) {
            super(brand, model, year, price);
        }
    }

    // Подкласс Бизнес класс
    static class BusinessCar extends PassengerCar {
        public BusinessCar(String brand, String model, int year, double price) {
            super(brand, model, year, price);
        }
    }

    // Подкласс Премиум класс
    static class PremiumCar extends PassengerCar {
        public PremiumCar(String brand, String model, int year, double price) {
            super(brand, model, year, price);
        }
    }

    // Класс Таксопарк
    static class TaxiPark {
        private List<Car> cars;

        public TaxiPark() {
            cars = new ArrayList<>();
        }

        public void addCar(Car car) {
            cars.add(car);
        }

        public double calculateTotalPrice() {
            double totalPrice = 0;
            for (Car car : cars) {
                totalPrice += car.getPrice();
            }
            return totalPrice;
        }

        public void displayCars() {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        // Создаем таксопарк
        TaxiPark taxiPark = new TaxiPark();

        // Добавляем автомобили в таксопарк
        taxiPark.addCar(new EconomyCar("Toyota", "Corolla", 2020, 20000));
        taxiPark.addCar(new BusinessCar("BMW", "5 Series", 2021, 50000));
        taxiPark.addCar(new PremiumCar("Mercedes", "S-Class", 2022, 100000));

        // Отображаем все автомобили в таксопарке
        System.out.println("Автомобили в таксопарке:");
        taxiPark.displayCars();

        // Подсчитываем общую стоимость автопарка
        System.out.println("Общая стоимость автопарка: $" + taxiPark.calculateTotalPrice());
    }
}