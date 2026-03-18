import java.util.*;

public class ConcurrentBookingProcessor implements Runnable {

    // Shared resources
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    // Constructor
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation = null;

            // 🔥 CRITICAL SECTION 1 (QUEUE ACCESS)
            synchronized (bookingQueue) {

                if (bookingQueue.isEmpty()) {
                    break; // stop thread if no requests
                }

                reservation = bookingQueue.getNextRequest();
            }

            // 🔥 CRITICAL SECTION 2 (INVENTORY + ALLOCATION)
            synchronized (inventory) {

                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}