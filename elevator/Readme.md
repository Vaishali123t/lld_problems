**Features:**

1. There could be multiple floors in a building.
2. There could be multiple elevators. 
3. Elevators have indicators showing current floor and direction. -> not shown currently
3. There will be up and down buttons in lobby area in each floor.
4. When an up/down button is clicked from a floor -> one of the elevators must stop at given floor(and must point to correct direction).
5. Inside the elevator there should be buttons for each floor.
6. When a floor button is clicked, the elevator adds that floor to list of floors it must stop at and later stops there.
7. Situation -> if lift stops on floor 2, lift is moving upwards and a person clicks floor 1, what happens? -> NearestMovementStrategy, or it keeps going up first.


**Advanced:**
• Emergency stop functionality must be available.
• Overload detection prevents elevator movement if capacity is exceeded.
• Door sensors prevent doors from closing if obstructed.

________

**Identifying enums:**
1. ElevatorDirection (UP,DOWN,IDLE)
2. ElevatorState (MOVING,HALTED)
3. Direction(UP, DOWN) -> represents the direction user wants to go to

**Identifying entities:**
1. Building
2. Floor
3. Elevator
4. Door
5. Button (interface for both outside and inside diff functionalities on onClick)

____

**Design patterns used**

1. **Singleton**: Building. 
2. **Factory method**: .
3. **Strategy pattern**: Movement Strategy, Elevator assignment strategy

_____

