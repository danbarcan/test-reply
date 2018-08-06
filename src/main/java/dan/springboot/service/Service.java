package dan.springboot.service;

import java.util.ArrayList;
import java.util.List;

import dan.springboot.model.Car;
import dan.springboot.model.Demand;
import dan.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class Service {

    private static List<User> users = new ArrayList<>();
    private static List<Car> cars = new ArrayList<>();
    private static List<Demand> demands = new ArrayList<>();

    public List<User> retrieveAllUsers() {
        return users;
    }

    public User addUser(User user) {
        if (users.add(user)) {
            return user;
        }
        return null;
    }

    public User retrieveUser(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUser(User user) {
        for (User u : users) {
            if (u.getId().equals(user.getId())) {
                int index = users.indexOf(u);
                users.set(index, user);
                return true;
            }
        }
        return false;
    }

    public boolean removeUser(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return users.remove(user);
            }
        }
        return false;
    }

    public List<Car> retrieveAllCars() {
        return cars;
    }

    public Car addCar(Car car) {
        if (cars.add(car)) {
            return car;
        }
        return null;
    }

    public Car retrieveCar(Integer id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public boolean updateCar(Car car) {
        for (Car c : cars) {
            if (c.getId().equals(car.getId())) {
                int index = users.indexOf(c);
                cars.set(index, car);
                return true;
            }
        }
        return false;
    }

    public boolean removeCar(Integer id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return cars.remove(car);
            }
        }
        return false;
    }

    public List<Demand> retrieveAllDemands() {
        return demands;
    }

    public Demand addDemand(Demand demand) {
        if (demands.add(demand)) {
            return demand;
        }
        return null;
    }

    public Demand retrieveDemand(Integer id) {
        for (Demand demand : demands) {
            if (demand.getId().equals(id)) {
                return demand;
            }
        }
        return null;
    }

    public boolean updateDemand(Demand demand) {
        for (Demand d : demands) {
            if (d.getId().equals(demand.getId())) {
                int index = users.indexOf(d);
                demands.set(index, demand);
                return true;
            }
        }
        return false;
    }

    public boolean removeDemand(Integer id) {
        for (Demand demand : demands) {
            if (demand.getId().equals(id)) {
                return demands.remove(demand);
            }
        }
        return false;
    }
}