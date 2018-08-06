package dan.springboot.controller;

import dan.springboot.model.Car;
import dan.springboot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private Service service;

    @GetMapping("/cars")
    public List<Car> retrieveCars() {
        return service.retrieveAllCars();
    }

    @GetMapping("/cars/{id}")
    public Car retrieveCar(@PathVariable Integer id) {
        return service.retrieveCar(id);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> removeCar(@PathVariable Integer id) {
        if (service.removeCar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/cars/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        if (service.updateCar(car)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("cars")
    public Car addCar(@RequestBody Car car) {
        return service.addCar(car);
    }
}
