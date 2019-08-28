public class FastCar extends Car {
    static {
        System.out.println("FastCar loaded");
    }

    public FastCar() {
        super();
        System.out.println("FastCar instantiated");
    }
}
