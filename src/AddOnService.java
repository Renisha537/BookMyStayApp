public class AddOnService {

    private String serviceName;
    private double cost;

    // Constructor
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    // Getter for service name
    public String getServiceName() {
        return serviceName;
    }

    // Getter for cost
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return serviceName + " (" + cost + ")";
    }
}