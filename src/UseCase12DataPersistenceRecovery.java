public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("=== Data Persistence & Recovery ===");

        String filePath = "inventory.txt";

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // STEP 1: LOAD PREVIOUS STATE (on startup)
        persistenceService.loadInventory(inventory, filePath);

        // Show current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailableRooms("Single"));
        System.out.println("Double: " + inventory.getAvailableRooms("Double"));
        System.out.println("Suite: " + inventory.getAvailableRooms("Suite"));

        // Simulate booking (modify inventory)
        inventory.updateAvailability("Single", inventory.getAvailableRooms("Single") - 1);

        System.out.println("\nAfter Booking (Single room reduced):");
        System.out.println("Single: " + inventory.getAvailableRooms("Single"));

        // STEP 2: SAVE STATE (before shutdown)
        persistenceService.saveInventory(inventory, filePath);

        System.out.println("\nRestart the program to see recovery in action.");
    }
}