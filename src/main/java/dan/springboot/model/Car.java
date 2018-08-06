package dan.springboot.model;

public class Car {

    private Integer id;
    private String model;
    private String engine;
    private String infotainmentSystem;
    private String interiorDesign;
    private Double currentLocation;

    public Car() {
    }

    public Car(Integer id, String model, String engine, String infotainmentSystem, String interiorDesign, Double currentLocation) {
        this.id = id;
        this.model = model;
        this.engine = engine;
        this.infotainmentSystem = infotainmentSystem;
        this.interiorDesign = interiorDesign;
        this.currentLocation = currentLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getInfotainmentSystem() {
        return infotainmentSystem;
    }

    public void setInfotainmentSystem(String infotainmentSystem) {
        this.infotainmentSystem = infotainmentSystem;
    }

    public String getInteriorDesign() {
        return interiorDesign;
    }

    public void setInteriorDesign(String interiorDesign) {
        this.interiorDesign = interiorDesign;
    }

    public Double getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Double currentLocation) {
        this.currentLocation = currentLocation;
    }
}