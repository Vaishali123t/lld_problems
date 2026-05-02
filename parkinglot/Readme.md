**Features:**

1. Multiple floors & spots
2. Different types of spots (SMALL, MEDIUM, LARGE)
3. Different types of vehicles (BIKE, CAR, TRUCKS)
4. Multiple Gates of different types (Entry and exit)
5. Vehicle enters through entry gate-> spot is assigned acc to vehicle type ticket is issued with entry timestamp
6. Vehicle exits through exit gate-> fee calculated -> payment done -> spot freed -> vehicle exits
7. Multiple fee calculation strategies -> Hourly Rate, Minute Rate etc
8. Multiple payment strategies -> UPI, CASH, CREDIT CARD


**Advanced:**
1. Real time display of available spots per floor 
2. Track all active tickets 

________

**Identifying enums:**

1. VehicleSize -> SMALL, MEDIUM, LARGE
2. SpotType -> COMPACT, REGULAR, LARGE
3. PaymentType -> CREDIT_CARD, CASH, UPI
4. SpotStatus -> AVAILABLE, OCCUPIED


**Identifying entities:**

1. ParkingLot
2. ParkingFloor
3. ParkingSpot
4. Vehicle -> Bike, Car, Truck
5. Gate -> EntryGate, ExitGate
6. Ticket
7. Fee
8. Payment

____

**Design patterns used**

1. **Singleton**: For creating PakingLot. 
2. **Factory method**: For creating payment strategy, fee calculation.
3. **Strategy pattern**: Fee calculation, payment.





