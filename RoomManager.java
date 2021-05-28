package game;

import fixtures.Room;

public class RoomManager {
	
	private Room startingRoom;

	//Basic array to hold onto all rooms in our house
	private Room[] rooms;
	
	public RoomManager(int roomCount) {
		super();
		rooms = new Room[roomCount];
		}
	
	public void init() {
// TODO: Implement
/*
* method that is used to create our house... 
* create multiple Room object and/or Knick-Knacks (Fixtures)
* within those rooms. Establish exits, etc...
 */
	    Room foyer = new Room(
	    		"The Foyer",
	    		"a small entry way leading into my home",
	    		"A dining room is open to the south, where a large table can be seen.\n"
	    		+ "To the north is a small room, where you can see a piano.");
	    		this.rooms[0] = foyer;
	    		
	    Room dining = new Room(
    			"The Dining Room",
    			"a large Dining Room",
    			"The large room for elegant dining containing a large table.\n"
    			+"A small foyer is open to the north, a stove can be seen in a room to the east" + "\n");
    			this.rooms[1] = dining;
    			
    	Room living = new Room(
    	    	"The living Room",
    	    	"a small living Room",
    	    	"The small room for social engagement . A small foyer is open to the south, a bed can be \n"
    	    	+"seen through a door to the east" + "\n");
    	    	this.rooms[2] = living;
    	    	
        Room kitchen = new Room(
    		   "The Kitchen",
    		   "A medium sized kitchen",
    		   "A place to cook food, there are no other doors other than \n"
    		   +"the one that you just passed thru");
    		   this.rooms[3] = kitchen;
    		   
        Room bedroom = new Room(
    		   "The bedroom",
    		   "A medium sized bedroom",
    		   "A place to sleep, there are no other doors than the one that you just passed thru.");
    		   this.rooms[4] = bedroom;
    		   
	           this.startingRoom = foyer;

	           //sets exits
	           foyer.setExits(dining, 1);
	    	   foyer.setExits(living, 0);
	    	   living.setExits(foyer, 1);
	    	   living.setExits(bedroom, 3);
	    	   dining.setExits(foyer, 0);
	    	   dining.setExits(kitchen, 3);
	    	   bedroom.setExits(living, 2);
	    	   kitchen.setExits(dining, 2);
	}

// Find a single room...
	public Room getRoom(int index) {
		return rooms[index];
	}

	/*
* Used to find a specific room using the room's name
*/
	public Room getRoom(String roomName) {
		int index = 0;
		for (int i = 0; i < rooms.length; i++) {
			if (roomName == rooms[i].getName().toUpperCase()) {
				index = i;
			}
		}
		return getRoom(index);
	}
	
/*
* Getters and Setters...
*/
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
	
	public Room[] getRooms() {
		return this.rooms;
	}
	
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
}
