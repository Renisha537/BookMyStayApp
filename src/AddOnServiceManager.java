import java.util.*;

public class AddOnServiceManager {

    // Map: Reservation ID -> List of services
    private Map<String, List<AddOnService>> servicesByReservation;

    // Constructor
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    // Add service to a reservation
    public void addService(String reservationId, AddOnService service) {

        // If reservation not present, create new list
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());

        // Add service
        servicesByReservation.get(reservationId).add(service);
    }

    // Calculate total service cost
    public double calculateTotalServiceCost(String reservationId) {
        double total = 0;

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddOnService service : services) {
                total += service.getCost();
            }
        }

        return total;
    }

    // Optional: Display services
    public void displayServices(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services added.");
            return;
        }

        System.out.println("Services for Reservation " + reservationId + ":");
        for (AddOnService s : services) {
            System.out.println("- " + s);
        }
    }
}