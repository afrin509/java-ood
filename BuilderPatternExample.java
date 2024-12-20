// Product: Vehicle
class Vehicle {
    private String type;
    private int wheels;
    private String engine;
    private boolean hasPedals;

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setHasPedals(boolean hasPedals) {
        this.hasPedals = hasPedals;
    }

    // toString for displaying vehicle details
    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", wheels=" + wheels +
                ", engine='" + engine + '\'' +
                ", hasPedals=" + hasPedals +
                '}';
    }
}

// Builder Interface: VehicleBuilder
interface VehicleBuilder {
    void setVehicleType();
    void addWheels();
    void addEngine();
    void addPedals();
    Vehicle getVehicle(); // Return the constructed product
}

// Concrete Builder: CarBuilder
class CarBuilder implements VehicleBuilder {
    private Vehicle vehicle;

    public CarBuilder() {
        this.vehicle = new Vehicle();
    }

    @Override
    public void setVehicleType() {
        vehicle.setType("Car");
    }

    @Override
    public void addWheels() {
        vehicle.setWheels(4);
    }

    @Override
    public void addEngine() {
        vehicle.setEngine("Internal Combustion Engine");
    }

    @Override
    public void addPedals() {
        vehicle.setHasPedals(false);
    }

    @Override
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}

// Concrete Builder: BicycleBuilder
class BicycleBuilder implements VehicleBuilder {
    private Vehicle vehicle;

    public BicycleBuilder() {
        this.vehicle = new Vehicle();
    }

    @Override
    public void setVehicleType() {
        vehicle.setType("Bicycle");
    }

    @Override
    public void addWheels() {
        vehicle.setWheels(2);
    }

    @Override
    public void addEngine() {
        vehicle.setEngine("None");
    }

    @Override
    public void addPedals() {
        vehicle.setHasPedals(true);
    }

    @Override
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}

// Concrete Builder: MotorcycleBuilder
class MotorcycleBuilder implements VehicleBuilder {
    private Vehicle vehicle;

    public MotorcycleBuilder() {
        this.vehicle = new Vehicle();
    }

    @Override
    public void setVehicleType() {
        vehicle.setType("Motorcycle");
    }

    @Override
    public void addWheels() {
        vehicle.setWheels(2);
    }

    @Override
    public void addEngine() {
        vehicle.setEngine("Internal Combustion Engine");
    }

    @Override
    public void addPedals() {
        vehicle.setHasPedals(false);
    }

    @Override
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}

// Director: Manufacturer
class Manufacturer {
    private VehicleBuilder builder;

    public void setBuilder(VehicleBuilder builder) {
        this.builder = builder;
    }

    public Vehicle buildVehicle() {
        builder.setVehicleType();
        builder.addWheels();
        builder.addEngine();
        builder.addPedals();
        return builder.getVehicle();
    }
}

// Main class
public class BuilderPatternExample {
    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();

        // Build a Car
        VehicleBuilder carBuilder = new CarBuilder();
        manufacturer.setBuilder(carBuilder);
        Vehicle car = manufacturer.buildVehicle();
        System.out.println(car);

        // Build a Bicycle
        VehicleBuilder bicycleBuilder = new BicycleBuilder();
        manufacturer.setBuilder(bicycleBuilder);
        Vehicle bicycle = manufacturer.buildVehicle();
        System.out.println(bicycle);

        // Build a Motorcycle
        VehicleBuilder motorcycleBuilder = new MotorcycleBuilder();
        manufacturer.setBuilder(motorcycleBuilder);
        Vehicle motorcycle = manufacturer.buildVehicle();
        System.out.println(motorcycle);
    }
}

//import java.util.Optional;
//
//// Your existing visualObject implementations...
//
//class Maze {
//    private Room room;
//    private Wall wall;
//    private Ladder ladder;
//
//    private Maze(Room room, Wall wall, Ladder ladder) {
//        this.room = room;
//        this.wall = wall;
//        this.ladder = ladder;
//    }
//
//    public void getSpecifications() {
//        if (room != null) room.createObject();
//        if (wall != null) wall.createObject();
//        if (ladder != null) ladder.createObject();
//    }
//
//    public static class Builder {
//        private Room room = null;
//        private Wall wall = null;
//        private Ladder ladder = null;
//
//        public Builder withRoom(Room roomPrototype) {
//            if (roomPrototype != null) {
//                this.room = (Room) roomPrototype.Clonebject();
//            }
//            return this;
//        }
//
//        public Builder withWall(Wall wallPrototype) {
//            if (wallPrototype != null) {
//                this.wall = (Wall) wallPrototype.Clonebject();
//            }
//            return this;
//        }
//
//        public Builder withLadder(Ladder ladderPrototype) {
//            if (ladderPrototype != null) {
//                this.ladder = (Ladder) ladderPrototype.Clonebject();
//            }
//            return this;
//        }
//
//        public Maze build() {
//            return new Maze(room, wall, ladder);
//        }
//    }
//}
//public class PrototypePattern2 {
//    public static void main(String args[]) {
//        // Create concrete prototypes
//        Ladder l1 = new Ladder(20, "Yellow");
//        Room r1 = new Room(20, 60, "Rectangle");
//        Wall w1 = new Wall("Lime plaster");
//
//        // Use the Builder to construct the Maze
//        Maze maze = new Maze.Builder()
//                .withLadder(l1)
//                .withRoom(r1) // Add only the prototypes you want
//                .withWall(w1)
//                .build();
//
//        // Output specifications for debugging
//        maze.getSpecifications();
//    }
//}