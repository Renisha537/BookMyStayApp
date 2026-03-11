import java.util.Map;

public class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            SingleRoom singleRoom,
            DoubleRoom doubleRoom,
            SuiteRoom suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("===== AVAILABLE ROOMS =====");

        // Single Room check
        if (availability.get("Single") > 0) {
            System.out.println("\nSingle Room Available");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Single"));
        }

        // Double Room check
        if (availability.get("Double") > 0) {
            System.out.println("\nDouble Room Available");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Double"));
        }

        // Suite Room check
        if (availability.get("Suite") > 0) {
            System.out.println("\nSuite Room Available");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Suite"));
        }
    }
}