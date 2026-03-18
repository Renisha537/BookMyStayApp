public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Use ONLY 2 parameters (based on your constructor)
        Reservation r1 = new Reservation("RES101", "Alice");
        Reservation r2 = new Reservation("RES102", "Bob");
        Reservation r3 = new Reservation("RES103", "Charlie");

        // Add to history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}