package dan.springboot.model;

import java.time.LocalDateTime;

public class Demand {
    private Integer id;
    private Double pickUpLocation;
    private Double dropOffLocation;
    private LocalDateTime earliestPickUpTime;
    private LocalDateTime latestDropOffTime;
    private Car desiredCar;
    private Integer userId;

    public Demand() {
    }

    public Demand(Integer id, Double pickUpLocation, Double dropOffLocation, LocalDateTime earliestPickUpTime, LocalDateTime latestDropOffTime, Car desiredCar, Integer userId) {
        this.id = id;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.earliestPickUpTime = earliestPickUpTime;
        this.latestDropOffTime = latestDropOffTime;
        this.desiredCar = desiredCar;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Double pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Double getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(Double dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public LocalDateTime getEarliestPickUpTime() {
        return earliestPickUpTime;
    }

    public void setEarliestPickUpTime(LocalDateTime earliestPickUpTime) {
        this.earliestPickUpTime = earliestPickUpTime;
    }

    public LocalDateTime getLatestDropOffTime() {
        return latestDropOffTime;
    }

    public void setLatestDropOffTime(LocalDateTime latestDropOffTime) {
        this.latestDropOffTime = latestDropOffTime;
    }

    public Car getDesiredCar() {
        return desiredCar;
    }

    public void setDesiredCar(Car desiredCar) {
        this.desiredCar = desiredCar;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getDistance() {
        return Math.abs(dropOffLocation - pickUpLocation);
    }
}
