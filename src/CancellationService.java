import java.util.*;

public class CancellationService {

    // Stack to track rollback (LIFO)
    private Stack<String> releasedRoomIds;

    // Map: reservationId → roomType
    private Map<String, String> reservationRoomTypeMap;

    // Constructor
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    // Register confirmed booking
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    // Cancel booking
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        // Validate reservation exists
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        // Get room type
        String roomType = reservationRoomTypeMap.get(reservationId);

        // 🔥 Restore inventory
        int current = inventory.getAvailableRooms(roomType);
        inventory.updateAvailability(roomType, current + 1);

        // 🔥 Track rollback (simulate room release ID)
        String releasedId = roomType + "-1";
        releasedRoomIds.push(releasedId);

        // Remove from active bookings
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    // Show rollback history
    public void showRollbackHistory() {

        System.out.println("\nRollback History (Most Recent First):");

        if (releasedRoomIds.isEmpty()) {
            System.out.println("No cancellations yet.");
            return;
        }

        for (String id : releasedRoomIds) {
            System.out.println("Released Reservation ID: " + id);
        }
    }
}