package Battleship2; // package

//random class import
import java.util.Random;

public class Ships { // class that holds ship objects

	int size = 0; // ship # of tiles
	int ID = 0; // ship ID
	Random rand = new Random(); // random object
	int randVars[] = new int[3]; // stores random variables
	boolean goodLoc = false; // stores if able to be placed in position
	boolean sunk = false; // stores if sink is sunk or not
	int spacesLeft = 0; // stores spaces of ship not hit (# of tiles left)

	Ships(int ID) { // constructor- constructs with ship ID

		if (ID == 1) // if ID = 1, ship is 3 tile
			size = 3; // set size to 3
		else // any other ID, ship is ID tile
			size = ID; // set size to ID

		this.ID = ID; // passes ID into object
		spacesLeft = size; // sets spaces left to size 

	}

	public void FindArea(int[][] loc) { // finds area for CPU ships

		do { // loops until a good location is found

			boolean exit = false; // sets exit to false (exit becomes true if bad location)

			//0/1 used for location, 2 used for direction
			randVars[0] = rand.nextInt(8);
			randVars[1] = rand.nextInt(8);
			randVars[2] = rand.nextInt(4) + 1; // 1 = up, 2 = down, 3 = left, 4
												// = right

			if (loc[randVars[0]][randVars[1]] == 0) { //continue if space is blank

				if (randVars[2] == 1) {//up
					if (9 - size > randVars[0]) {
						loc[randVars[0]][randVars[1]] = ID; //sets first spot
						for (int y = 1; y < size; y++) {
							if (loc[randVars[0] + y][randVars[1]] > 0) { // if location !=0 (already taken)
								loc[randVars[0]][randVars[1]] = 0;
								exit = true; // exits 
							}
						}
						if (!exit) { // good location
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[randVars[0] + z][randVars[1]] = ID; // fill 

						} else
							exit = false;
					}
				} else if (randVars[2] == 2) { //down
					if (9 - size > randVars[1]) {
						loc[randVars[0]][randVars[1]] = ID;
						for (int y = 1; y < size; y++) {
							if (loc[randVars[0]][randVars[1] + y] != 0) {
								loc[randVars[0]][randVars[1]] = 0;
								exit = true;
							}
						}
						if (!exit) {
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[randVars[0]][randVars[1] + z] = ID;

						} else
							exit = false;
					}
				} else if (randVars[2] == 3) { // left
					if (randVars[0] > size - 2) {
						loc[randVars[0]][randVars[1]] = ID;
						for (int y = 1; y < size; y++) {
							if (loc[randVars[0] - y][randVars[1]] != 0) {
								loc[randVars[0]][randVars[1]] = 0;
								exit = true;
							}
						}
						if (!exit) {
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[randVars[0] - z][randVars[1]] = ID;

						} else
							exit = false;
					}
				} else if (randVars[2] == 4) { // right
					if (randVars[1] > size - 2) {
						loc[randVars[0]][randVars[1]] = ID;
						for (int y = 1; y < size; y++) {
							if (loc[randVars[0]][randVars[1] - y] != 0) {
								loc[randVars[0]][randVars[1]] = 0;
								exit = true;
							}
						}
						if (!exit) {
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[randVars[0]][randVars[1] - z] = ID;

						} else
							exit = false;
					}
				}

			}

		} while (!goodLoc);

	}

	public boolean CheckArea(int[][] loc, int vert, int horiz, int dir) { // checks player clicks

		boolean exit = false;
		
		// variables passed from gameframe
		randVars[0] = vert;
		randVars[1] = horiz;
		randVars[2] = dir; // 1 = down, 2 = right

		if (loc[randVars[0]][randVars[1]] == 0) {

			if (randVars[2] == 1) {
				if (9 - size > randVars[0]) {
					loc[randVars[0]][randVars[1]] = ID;
					for (int y = 1; y < size; y++) {
						if (loc[randVars[0] + y][randVars[1]] > 0) {
							loc[randVars[0]][randVars[1]] = 0;
							System.out.println("bad location");
							exit = true;

						}
					}
					if (!exit) {
						goodLoc = true;
						for (int z = 1; z < size; z++)
							loc[randVars[0] + z][randVars[1]] = ID;
						for (int z = 0; z < size; z++) {

						}
					} else
						exit = false;
				} else
					System.out.println("bad location");

			} else if (randVars[2] == 2) {
				if (9 - size > randVars[1]) {
					loc[randVars[0]][randVars[1]] = ID;
					for (int y = 1; y < size; y++) {
						if (loc[randVars[0]][randVars[1] + y] != 0) {
							loc[randVars[0]][randVars[1]] = 0;
							System.out.println("bad location");
							exit = true;
						}
					}
					if (!exit) {
						goodLoc = true;
						for (int z = 1; z < size; z++)
							loc[randVars[0]][randVars[1] + z] = ID;

					} else
						exit = false;
				} else
					System.out.println("bad location");

			}

		}

		if (goodLoc) // returns true so the ship can be placed on board
			return true;
		else // returns false so another location can be chosen
			return false;
	}
}
