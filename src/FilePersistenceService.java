import java.io.*;
import java.util.Map;

public class FilePersistenceService {

    // Save inventory to file
    public void saveInventory(RoomInventory inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {

                // Format: roomType-count
                writer.write(entry.getKey() + "-" + entry.getValue());
                writer.newLine();
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load inventory from file
    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        // Handle missing file (VERY IMPORTANT)
        if (!file.exists()) {
            System.out.println("No previous data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Format: roomType-count
                String[] parts = line.split("-");

                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    inventory.updateAvailability(roomType, count);
                }
            }

            System.out.println("Inventory loaded successfully.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory. Starting with default values.");
        }
    }
}