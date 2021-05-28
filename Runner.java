package game;

import java.util.Scanner;

import fixtures.Room;

public class Runner {

	private static RoomManager manager = new RoomManager(5);
	
	// Boolean used to control when our game is running. We set it to true initially
	private static boolean running = true;
		
	// Main method
	public static void main(String[] args) {
		
		// Run the init method to instantiate our house
		manager.init();
		//set condition for while loop
		running = true;
		//instantiate our player
		Player player = new Player();
		//message to user for the basics
		System.out.println("Welcome to my virtual home \n"
				+ "This walkthru is a work in progress \n"
				+ "Type go or move and direction of travel \n"
				+ "i.e. north, south, east or west to move \n");
		
		//determines starting location
		player.setCurrentRoom(manager.getStartingRoom());
		printRoom(player);

		//while loop for 
		while (running) {

			// Collect input
			String[] input = collectInput();
			
			// Parse the input to look for commands "GO NORTH", "MOVE SOUTH", etc...
			parse(input, player);
			
			if (running) {
				// Print messages to the console
				printRoom(player);
			}
		}
		
		// After the game ends...
		if (!running) {
			System.out.println("Thanks for playing");
		}
	}
	
	// This method prints information to the console regarding the player's current room
	private static void printRoom(Player player) {
		System.out.println(":::: CURRENT ROOM ::::");
		System.out.println("Name: " + player.getCurrentRoom().getName());
		System.out.println("Desc: " + player.getCurrentRoom().getShortDesc());
		System.out.println(player.getCurrentRoom().getLongDesc());
	}
	
	//gather and parse user input
	private static String[] collectInput() {
		//resource leak with running scan needs to be addressed
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] phrase = input.split(" ");
		return phrase;
	}
	
	/*
	 * This method should take an array of Strings and
	 * update the player's position based on the input
	 * received (or even exit the game)
	 * 
	 * parse - analyze (a sentence) into parts and describe
	 *   their syntactic roles...
	 * 
	 * What do each of the words of our String array input
	 * represent? If someone enters "MOVE NORTH" what should
	 * happen? or "PICK UP LAMP", etc...
	 * 
	 * NOTE:
	 *   using toLowerCase() or toUpperCase() on a String will
	 *   help when parsing input
	 *   i.e. should there be a difference between:
	 *   	"move"
	 *   	"MOVE"
	 *   	"Move"
	 *   	"moVe"
	 */
	// This takes in a string array that we can look through for the command the player entered
	// We then move/interact with the room based on the input and pass that information to the player
	private static void parse(String[] command, Player player) {
		/*
		 *  There is a potential bug in this code...What happens 
		 *  when we give one 1 command? or if we enter a wrong 
		 *  command? This should be addressed...
		 */
		
		/*
		 * The intern function will move string objects to the
		 * String pool...remember, string literals are put in 
		 * the String pool. Sometimes Java can do this for us, 
		 * but using intern method guarantees this behavior
		 */
		String action = command[0].toUpperCase().intern();
		String direction = "";
		if (command.length > 1) {
			direction = command[1].toUpperCase().intern();			
		}
		
		if (action == "GO" | action == "MOVE") {
			System.out.println("Moving to: " + direction);
			Room move = player.getCurrentRoom().getExit(direction);
			player.setCurrentRoom(move);
		} else if (action == "QUIT") {
			// Here, we stop the game
			running = false;
		}
	}
}
