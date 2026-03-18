import java.util.*;

public class BookingReportService {

    public void generateReport(BookingHistory history) {

        List<Reservation> reservations = history.getConfirmedReservations();

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("===== BOOKING REPORT =====");

        int totalBookings = reservations.size();

        for (Reservation r : reservations) {
            System.out.println("----------------------------");

            // Safe print (uses your existing class)
            System.out.println(r);
        }

        System.out.println("----------------------------");
        System.out.println("Total Bookings: " + totalBookings);
    }
}