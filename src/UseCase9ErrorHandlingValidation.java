import java.util.Scanner;

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("=== Booking Validation ===");

        Scanner scanner = new Scanner(System.in);

        // Existing system components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // Take input
            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter Room Type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // VALIDATION STEP (FAIL FAST)
            validator.validate(guestName, roomType, inventory);

            // If valid → proceed
            Reservation reservation = new Reservation(guestName, roomType);
            bookingQueue.addRequest(reservation);

            System.out.println("Booking request added successfully!");

        } catch (InvalidBookingException e) {

            // Graceful error handling
            System.out.println("Booking failed: " + e.getMessage());

        } catch (Exception e) {

            // Safety fallback
            System.out.println("Unexpected error occurred.");

        } finally {
            scanner.close();
        }
    }
}