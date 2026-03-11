import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 3: Centralized Room Inventory Management
 *
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * @version 3.1
 */

public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {

        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);

    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }


    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}