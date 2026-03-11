import java.util.*;

/**
 * ============================================================================
 * CLASS - RoomAllocationService
 * ============================================================================
 * Use Case 6: Reservation Confirmation & Room Allocation
 * * Description:
 * This class is responsible for confirming booking requests and
 * assigning unique rooms while maintaining inventory integrity.
 */
public class RoomAllocationService {

    /** Stores all allocated room IDs globally to prevent duplicate assignments. */
    private Set<String> allocatedRoomIds;

    /** Maps Room Type to a Set of specific assigned room IDs. */
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Initializes allocation tracking structures.
     */
    public RoomAllocationService() {
        this.allocatedRoomIds = new HashSet<>();
        this.assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning a unique room ID
     * and updating your RoomInventory single source of truth.
     * * @param reservation booking request
     * @param inventory your centralized RoomInventory instance
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();

        // 1. Check availability using your existing Map structure
        int availableCount = currentAvailability.getOrDefault(type, 0);

        if (availableCount > 0) {
            // 2. Generate a unique ID (e.g., Suite-101)
            String roomId = generateRoomId(type);

            // 3. Record the allocation to prevent reuse
            allocatedRoomIds.add(roomId);

            // 4. Map the ID to the Room Type category
            assignedRoomsByType.computeIfAbsent(type, k -> new HashSet<>()).add(roomId);

            // 5. Update your inventory using your existing updateAvailability method
            inventory.updateAvailability(type, availableCount - 1);

            System.out.println("[CONFIRMED] " + reservation.getGuestName() +
                    " assigned to " + roomId +
                    ". Remaining " + type + " rooms: " + (availableCount - 1));
        } else {
            System.out.println("[FAILED] No rooms available for " + reservation.getGuestName() + " (" + type + ")");
        }
    }

    /**
     * Generates a unique room ID for the given room type.
     * It loops until it finds an ID not present in the allocatedRoomIds Set.
     */
    private String generateRoomId(String roomType) {
        int floor = 1;
        String newId;
        do {
            newId = roomType.substring(0, 3).toUpperCase() + "-" + (floor + 100);
            floor++;
        } while (allocatedRoomIds.contains(newId));

        return newId;
    }
}