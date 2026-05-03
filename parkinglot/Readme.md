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

_____
Some queries?

**1. Why IPaymentStrategy and IFeeStrategy are not a part of any class while IParkingStrategy is a part of ParkingService?
Ans.** Acc to design, IPaymentStrategy and IFeeStrategy are dynamically selected by user. While IParkingStrategy is selected at the time of
creation of parking lot as we are saying that parking strategy will be same for every vehicle (not vehicle specfic). 
We can do the same for IFeeStrategy if we want to consider that the Fee strategy will be same for every vehicle in the parking code. Or we could have added IFeeStrategy
in Vehicle if we want every Vehicle to have diff fee strategy. But that is not ideal as well, it should ideally be dynamically selected as we have done in the code.

**2. Currently, we are having a TC of O(N*N) for the method findParkingSpot for finding spot each time? Is there a better approach?
Ans.** Yes, we should keep some kind of a map in ParkingService Map<SpotType,Queue<ParkingSpot>>. This map should contain available parking spots for each spot type.
We can make the map **concurrent** in order for concurrency control.

**3. Why are you storing full objects instead of IDs?
Ans.** For in-memory LLD simplicity. In production, I’d store IDs and fetch from repositories to reduce coupling and enable distribution. NOTE: Make sure you store complete 
objects in class during interviews, ids make it complex.

**4. How would you support multiple parking lots?
Ans.** Remove Singleton, Add a parkinglot manager for creating parkinglots and manage them say based on location.

**5. Why do gates use ParkingService?
Ans.** Gates are thin controllers; they delegate business logic to the service layer. But since the entering and exiting happens through them it makes sense to create enter
 or exit methods there and delegate business logic to ParkingService.

**6. What if I want to create Display boards? How will display boards update?
Ans.** Observer pattern.

**7. When to create an interface, when to create an abstract class and when to use an enum of type in the class?
Ans.** _Interface_: interchangeable behaviours, no shared state (attributes)
     _Abstract class_: share state and partially implement behavior across subclasses
     _Enum_: Values are finite and fixed, no complex behaviour differences



