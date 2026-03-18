public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("=== Booking Cancellation ===");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Cancellation service
        CancellationService service = new CancellationService();

        // Simulate confirmed booking
        String reservationId = "RES101";
        String roomType = "Single";

        service.registerBooking(reservationId, roomType);

        // Cancel booking
        service.cancelBooking(reservationId, inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Show updated inventory
        int updated = inventory.getAvailableRooms("Single");
        System.out.println("\nUpdated Single Room Availability: " + updated);
    }
}