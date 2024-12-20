// Abstract Factory interface
interface CarFactory {
    int produceDoors();
    int produceWindows();
}

// Product interface
interface CarProducts {
    void productDoorsInitiated();
    void productWindowsInitiated();
}

// Concrete Products
class SpecificProducts implements CarProducts {
    private int doors, windows;
    private String name;

    SpecificProducts(int doors, int windows, String name) {
        this.doors = doors;
        this.windows = windows;
        this.name = name;
    }

    public void productDoorsInitiated() {
        System.out.println(this.name + " is producing " + this.doors + " doors");
    }

    public void productWindowsInitiated() {
        System.out.println(this.name + " is producing " + this.windows + " windows");
    }
}

// Concrete Factory
class SpecificFactory implements CarFactory {
    private int doors, windows, gst;
    private String name;
    private SpecificProducts products;

    SpecificFactory(int doors, int windows, String name, int gst) {
        this.doors = doors;
        this.windows = windows;
        this.name = name;
        this.gst = gst;
        products = new SpecificProducts(doors, windows, name);
    }

    @Override
    public int produceDoors() {
        products.productDoorsInitiated();
        return this.doors + gst;
    }

    @Override
    public int produceWindows() {
        products.productWindowsInitiated();
        return this.windows + gst;
    }
}

// Client
class Client {
    private CarFactory factory;

    Client(CarFactory factory) {
        this.factory = factory;
    }

    public int getDoorPrice() {
        return this.factory.produceDoors();
    }

    public int getWindowPrice() {
        return this.factory.produceWindows();
    }
}

// Usage
public class AbstractFactory {
    public static void main(String args[]) {
        CarFactory factory1 = new SpecificFactory(50, 60, "BMW", 10);
        CarFactory factory2 = new SpecificFactory(70, 50, "FORD", 20);

        Client c1 = new Client(factory1);
        Client c2 = new Client(factory2);

        System.out.println("Client 1 OK proceeded " + c1.getDoorPrice());
        System.out.println("Client 2 OK proceeded " + c2.getWindowPrice());
    }
}