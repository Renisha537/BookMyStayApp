public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Existing room objects
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suiteRoom = new SuiteRoom();

        // Search service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}