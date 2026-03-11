This use case implements a search feature that enables guests to check room availability in the hotel booking system. The search operation retrieves room availability from the centralized inventory and displays only the room types that are currently available. The system uses room domain objects to present room details such as type, pricing, and amenities.

The search functionality is designed to be read-only, meaning it does not modify the inventory or booking data. This ensures that room searches remain safe operations and do not interfere with booking or allocation logic.
