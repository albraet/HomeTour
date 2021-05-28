package fixtures;

public class Room extends Fixture {
	// This is an array of the exits connected to this room
	Room[] exits;

	// Constructor for rooms
	public Room(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		this.exits = new Room[8];
	}

	// getter and setter for exits
	public Room[] getExits() {
		return this.exits;
	}

	// Method allows us to get a single exit based on the direction moving
	public Room getExit(String direction) {
		int index = 0;
		direction = direction.toUpperCase();
		switch (direction) {
			case "NORTH":
				index = 0;
				break;
			case "SOUTH":
				index = 1;
				break;
			case "WEST":
				index = 2;
				break;
			case "EAST":
				index = 3;
				break;
		}

		// If statement checks that you can actually move in the direction...
		if (index >= this.exits.length) {
			System.out.println("There is no room in that direction!");
			// The 'this' keyword is a reference to the current object...this room
			return this;
		}
		
		return this.exits[index];
	}

	// Overloaded setter method, allows us to set exits, one at a time
	public void setExits(Room exit, int index) {
		this.exits[index] = exit;
	}
}

