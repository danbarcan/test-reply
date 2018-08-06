package dan.springboot.service;

import dan.springboot.model.Car;
import dan.springboot.model.Demand;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ScheduleService {

    public Map<Demand, Car> getScheduleForAllDemands(List<Demand> demands, List<Car> cars) {
        return demands.stream().collect(Collectors.toMap(Function.identity(), demand -> findCarForDemand(demand, cars)));
    }

    public Car findCarForDemand(Demand demand, List<Car> cars) {
        List<Car> correspondingCars = cars.stream()
                .filter(car ->
                        (demand.getDesiredCar().getEngine() == null || car.getEngine().equals(demand.getDesiredCar().getEngine())) &&
                        (demand.getDesiredCar().getInfotainmentSystem() == null || car.getInfotainmentSystem().equals(demand.getDesiredCar().getInfotainmentSystem())) &&
                        (demand.getDesiredCar().getModel() == null || car.getEngine().equals(demand.getDesiredCar().getModel())))
                .collect(Collectors.toList());

        correspondingCars.sort((car1, car2) -> {
            Double distance1 = Math.abs(demand.getPickUpLocation() - car1.getCurrentLocation());
            Double distance2 = Math.abs(demand.getPickUpLocation() - car2.getCurrentLocation());

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime arrival1 = now.plus((long)(distance1 / 16.6), ChronoUnit.SECONDS);
            LocalDateTime arrival2 = now.plus((long)(distance2 / 16.6), ChronoUnit.SECONDS);

            if (arrival1.compareTo(demand.getEarliestPickUpTime()) > 0 && arrival2.compareTo(demand.getEarliestPickUpTime()) > 0) {
                return distance2.compareTo(distance1);
            } else if (arrival1.compareTo(demand.getEarliestPickUpTime()) > 0) {
                return -1;
            } else {
                return 1;
            }
        });

        return cars != null && cars.size() > 0 ? cars.get(0) : null;
    }
}