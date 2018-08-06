package dan.springboot.controller;

import dan.springboot.model.Car;
import dan.springboot.model.Demand;
import dan.springboot.service.ScheduleService;
import dan.springboot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DemandController {

    @Autowired
    private Service service;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/demands")
    public List<Demand> retrieveDemands() {
        return service.retrieveAllDemands();
    }

    @GetMapping("/demands/{id}")
    public Demand retrieveDemand(@PathVariable Integer id) {
        return service.retrieveDemand(id);
    }

    @DeleteMapping("/demands/{id}")
    public ResponseEntity<Void> removeDemand(@PathVariable Integer id) {
        if (service.removeDemand(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/demands/{id}")
    public ResponseEntity<Void> updateDemand(@PathVariable Integer id, @RequestBody Demand demand) {
        if (service.updateDemand(demand)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/demands")
    public Demand addDemand(@RequestBody Demand demand) {
        return service.addDemand(demand);
    }

    @GetMapping("/scheduler")
    public Map<Demand, Car> retrieveScheduler() {
        return scheduleService.getScheduleForAllDemands(service.retrieveAllDemands(), service.retrieveAllCars());
    }
}
