import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * ============================================================================
 * Use Case 6: Reservation Confirmation & Room Allocation
 */
public class UseCase6RoomAllocation {

    public static void main(String[] args) {
        // 1. Setup your existing RoomInventory
        RoomInventory inventory = new RoomInventory(); // Starts with Single: 5, Double: 3, Suite: 2

        // 2. Setup the Allocation Service
        RoomAllocationService allocationService = new RoomAllocationService();

        // 3. Create a FIFO Queue for your Reservation objects
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Adding requests (simulating Use Case 5)
        bookingQueue.add(new Reservation("John Doe", "Suite"));
        bookingQueue.add(new Reservation("Jane Smith", "Suite"));
        bookingQueue.add(new Reservation("Unexpected Guest", "Suite")); // There are only 2 Suites

        System.out.println("--- Processing Bookings (FIFO Order) ---");

        // 4. Dequeue and Process
        while (!bookingQueue.isEmpty()) {
            Reservation request = bookingQueue.poll();
            allocationService.allocateRoom(request, inventory);
        }

        System.out.println("\nFinal Inventory State: " + inventory.getRoomAvailability());
    }
}