package Battleship2; // package

//imports 
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame implements MouseListener { // main class

	boolean gameStarted = false; // boolean to check if game has started or not
	boolean disable = false; // boolean to disable game buttons
	Random rand = new Random(); // randomizer
	JFrame window = new JFrame("Place Your Ships!"); // main window, holds
														// panels
	JPanel gridPanel = new JPanel(); // panel to hold 8x8 grid PLayer ships
	JPanel CPUgrid = new JPanel(); // panel to hold 8x8 grid CPU ships

	JButton locations[][] = new JButton[8][8]; // stores button form of CPU
												// ships
	int textLoc[][] = new int[8][8]; // stores int form of CPU ships
	JButton CPUlocations[][] = new JButton[8][8]; // stores button form of CPU
													// ships
	int CPUtextLoc[][] = new int[8][8]; // stores int form of CPU ships
	int row, row2 = 0; // stores rows picked
	int column, column2 = 0; // stores rows picked
	boolean spotfound = false;
	int difficulty = 0;

	JPanel consetHolder = new JPanel(); // panel to hold confirm and reset
	JButton confirmButton = new JButton("Confirm"); // confirm button
	JButton resetButton = new JButton("Reset"); // reset button
	JButton close = new JButton("Close"); // close window button

	Ships carrierPL, battleshipPL, cruiserPL, submarinePL, destroyerPL = null; // creates
																				// placeholders
																				// for
																				// PL
																				// ships
	Ships carrierCP, battleshipCP, cruiserCP, submarineCP, destroyerCP = null; // creates
																				// placeholders
																				// for
																				// CP
																				// ships
	int selectedShip = 5; // stores selected ship
	JLabel whichShip = new JLabel("You are curently placing the Carrier (5 long)"); // which
																					// ship
																					// label
																					// (later
																					// used
																					// for
																					// other)
	JLabel infoLabel = new JLabel("Left click to place your ship downwards, right click to place it to the right"); // generic
																													// information
																													// label
	JLabel infoLabel2 = new JLabel(); // generic information label
	JLabel cpuLabel = new JLabel("CPU's Board"); // label for cpu board

	public GameFrame(int dif) { // constructed with object

		difficulty = dif;
		// sets window, panel and generic button size, location and other
		// variables
		window.getContentPane().setLayout(null);
		window.getContentPane().setBackground(Color.BLACK);
		window.setSize(410, 500);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gridPanel.setLayout(null);
		gridPanel.setSize(410, 410);
		gridPanel.setBackground(Color.RED);
		consetHolder.setLocation(125, 450);
		consetHolder.setLayout(null);
		consetHolder.setSize(160, 30);
		close.addMouseListener(this);
		close.setFocusable(false);
		window.getContentPane().add(close);
		window.getContentPane().add(gridPanel);
		window.getContentPane().add(consetHolder);
		window.setVisible(true);

		for (int x = 0; x < locations[1].length; x++) { // creates array of
														// buttons for 8x8 grid
			for (int y = 0; y < locations[2].length; y++) {
				locations[x][y] = new JButton("~");
				locations[x][y].setBounds((x * 50) + 5, (y * 50) + 5, 50, 50);
				locations[x][y].addMouseListener(this);
				gridPanel.add(locations[x][y]); // adds to gridPanel panel
				locations[x][y].setEnabled(true);
				locations[x][y].setFocusable(false);
			}
		}

		// sets panel and buttons size, location and other variables
		confirmButton.addMouseListener(this);
		confirmButton.setBounds(0, 0, 80, 30);
		confirmButton.setFocusable(false);
		confirmButton.setEnabled(false);
		resetButton.addMouseListener(this);
		resetButton.setEnabled(true);
		resetButton.setBounds(80, 0, 80, 30);
		resetButton.setFocusable(false);
		consetHolder.add(confirmButton);
		consetHolder.add(resetButton);
		consetHolder.setBackground(Color.BLACK);

		whichShip.setHorizontalAlignment(SwingConstants.CENTER);
		whichShip.setBounds(0, 414, 410, 16);
		window.getContentPane().add(whichShip);

		infoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		infoLabel.setForeground(Color.RED);
		whichShip.setForeground(Color.WHITE);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(0, 432, 410, 16);
		window.getContentPane().add(infoLabel);

		placeCPUShips(); // calls method to place cpu ships

	}

	public void placeCPUShips() { // places CPU ships
		// creates 5 ships
		carrierCP = new Ships(5);
		battleshipCP = new Ships(4);
		cruiserCP = new Ships(3);
		submarineCP = new Ships(1);
		destroyerCP = new Ships(2);

		// finds area for 5 ships
		carrierCP.FindArea(CPUtextLoc);
		battleshipCP.FindArea(CPUtextLoc);
		cruiserCP.FindArea(CPUtextLoc);
		submarineCP.FindArea(CPUtextLoc);
		destroyerCP.FindArea(CPUtextLoc);

		// sets variables for the CPU ship grid
		CPUgrid.setLocation(415, 0);
		CPUgrid.setLayout(null);
		CPUgrid.setSize(410, 410);
		window.getContentPane().add(CPUgrid);
		cpuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cpuLabel.setBounds(415, 414, 410, 16);
		cpuLabel.setForeground(Color.WHITE);
		window.getContentPane().add(cpuLabel);
		CPUgrid.setVisible(false);

		// creates 8x8 grid for cpu ships and sets variables
		for (int x = 0; x < CPUlocations[1].length; x++) {
			for (int y = 0; y < CPUlocations[2].length; y++) {
				CPUlocations[x][y] = new JButton("~");
				CPUlocations[x][y].setBounds((x * 50) + 5, (y * 50) + 5, 50, 50);
				CPUlocations[x][y].addMouseListener(this);
				CPUgrid.add(CPUlocations[x][y]);
				CPUlocations[x][y].setEnabled(true);
				CPUlocations[x][y].setFocusable(false);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) { // checks which button is pressed
												// and does stuff with them
		if (!disable) { // runs if game is still going
			if (gameStarted == false) {
				JButton selected = (JButton) e.getSource(); // temp button
				boolean found = false;
				if ((selected == confirmButton) && (selectedShip == 0)) { // if
																			// clicked
																			// confirm
					startGame(); // start
				} else if (selected == resetButton) { // if clicked reset
					resetButtons(); // reset
				} else { // finds button clicked
					for (int x = 0; x < locations[1].length; x++) {
						for (int y = 0; y < locations[2].length; y++) {
							JButton find = locations[x][y];

							if (find == selected) {
								row = x;
								column = y;
								found = true;
							}
						}
					}
					if ((e.getButton() == 3) && (found)) // right click
						checkRight();

					if ((e.getButton() == 1) && (found)) // left clikc
						checkDown();

				}
			} else { // firing
				JButton selected = (JButton) e.getSource();
				boolean found = false;
				for (int x = 0; x < CPUlocations[1].length; x++) {
					for (int y = 0; y < CPUlocations[2].length; y++) {
						JButton find = CPUlocations[x][y];

						if (find == selected) { // finds button clicked
							row = x;
							column = y;
							found = true;
						}
					}
				}
				if ((e.getButton() == 1) && (found)) {// left click shoots
					fire();
				}

			}
		} else { // if game disabled, close enabled
			if ((JButton) e.getSource() == close)
				window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING)); // close
																							// if
																							// clicked
																							// close
		}
	}

	public void checkDown() { // checks down
		if (selectedShip == 5) { // ship ID 5
			carrierPL = new Ships(5);// create ship
			if (carrierPL.CheckArea(textLoc, row, column, 2)) { // if good loc
				UpdateButtons();// updates
				selectedShip--; // down to ship ID 4
				whichShip.setText("You are curently placing the Battleship (4 long)"); // update
																						// text
			}

		}
		if (selectedShip == 4) { // ship ID 4
			battleshipPL = new Ships(4);// create ship
			if (battleshipPL.CheckArea(textLoc, row, column, 2)) { // if good
																	// loc
				UpdateButtons();// updates
				selectedShip--; // down to ship ID 3
				whichShip.setText("You are curently placing the Cruiser (3 long)"); // update
																					// text
			}
		}
		if (selectedShip == 3) { // ship ID 3
			cruiserPL = new Ships(3); // create ship
			if (cruiserPL.CheckArea(textLoc, row, column, 2)) { // if good loc
				UpdateButtons();// updates
				selectedShip--; // down to ship ID 2
				whichShip.setText("You are curently placing the Destroyer (2 long)"); // update
																						// text
			}
		}
		if (selectedShip == 1) { // ship ID 1
			submarinePL = new Ships(1); // placing ship ID 1
			if (submarinePL.CheckArea(textLoc, row, column, 2)) { // if good
																	// location
				UpdateButtons();// updates
				selectedShip--; // down to 0
				whichShip.setText("You have placed all of your ships!"); // update
																			// text
				confirmButton.setEnabled(true);
			}
		}
		if (selectedShip == 2) { // placing ship ID 2
			destroyerPL = new Ships(2); // creates ship with id 2
			if (destroyerPL.CheckArea(textLoc, row, column, 2)) { // if location
																	// is good
				UpdateButtons(); // updates
				selectedShip--; // down to ship ID 1
				whichShip.setText("You are curently placing the Submarine (3 long)"); // update
																						// text
			}
		}
	}

	public void checkRight() { // same as checkDown() except checks right
		if (selectedShip == 5) {
			carrierPL = new Ships(5);
			if (carrierPL.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Battleship (4 long)");
			}
		}
		if (selectedShip == 4) {
			battleshipPL = new Ships(4);
			if (battleshipPL.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Cruiser (3 long)");
			}
		}
		if (selectedShip == 3) {
			cruiserPL = new Ships(3);
			if (cruiserPL.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Destroyer (2 long)");
			}
		}
		if (selectedShip == 1) {
			submarinePL = new Ships(1);
			if (submarinePL.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You have placed all of your ships!");
				confirmButton.setEnabled(true);
			}
		}
		if (selectedShip == 2) {
			destroyerPL = new Ships(2);
			if (destroyerPL.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Submarine (3 long)");
			}
		}
	}

	public void UpdateButtons() { // updates button colours and text if selected

		for (int x = 0; x < locations[1].length; x++) {
			for (int y = 0; y < locations[2].length; y++) {
				if (textLoc[x][y] != 0) { // if not empty space
					locations[x][y].setEnabled(false); // disable button
					locations[x][y].setOpaque(true); // opaque
				}
				if (textLoc[x][y] == 1) { // id 1
					locations[x][y].setBackground(Color.MAGENTA);
					locations[x][y].setText("X");
				} else if (textLoc[x][y] == 2) { // id 2
					locations[x][y].setBackground(Color.ORANGE);
					locations[x][y].setText("X");
				} else if (textLoc[x][y] == 3) { // id 3
					locations[x][y].setBackground(Color.GREEN);
					locations[x][y].setText("X");
				} else if (textLoc[x][y] == 4) { // id 4
					locations[x][y].setBackground(Color.CYAN);
					locations[x][y].setText("X");
				} else if (textLoc[x][y] == 5) { // id 5
					locations[x][y].setBackground(Color.YELLOW);
					locations[x][y].setText("X");
				}
			}
		}
	}

	public void resetButtons() { // resets ship placements and buttons
		for (int x = 0; x < locations[1].length; x++) {
			for (int y = 0; y < locations[2].length; y++) {
				locations[x][y].setEnabled(true);
				locations[x][y].setOpaque(false);
				locations[x][y].setBackground(null);
				locations[x][y].setText("~");
				textLoc[x][y] = 0;
			}
		}
		selectedShip = 5; // sets sel ship back
		whichShip.setText("You are curently placing the Carrier (5 long)"); // sets
																			// text
																			// back
		confirmButton.setEnabled(false); // disable confirm
	}

	public void startGame() { // initiates actual game

		gameStarted = true; // swaps mouselistener to game
		window.setSize(825, 515); // resizes window
		window.setLocationRelativeTo(null); // recenters
		window.setTitle("BATTLESHIP!");

		// updates labels
		infoLabel.setBounds(0, 435, 825, 22);
		infoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		infoLabel.setText("Take your shot! Pick a location on the CPU's board to fire.");
		infoLabel.setForeground(Color.WHITE);
		infoLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		infoLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel2.setForeground(Color.WHITE);
		infoLabel2.setBounds(0, 464, 825, 22);
		window.getContentPane().add(infoLabel2);

		// more label and button updates
		resetButton.setVisible(false);
		confirmButton.setVisible(false);
		whichShip.setText("Your Board");
		CPUgrid.setVisible(true);
		CPUgrid.setBackground(Color.BLUE);
		cpuLabel.setVisible(true);
	}

	public void fire() { // pick location to shoot
		if (CPUlocations[row][column].getText().equals("~")) { // avoid clicking
																// again
			if (CPUtextLoc[row][column] == 5) { // hit ship id 5
				infoLabel.setText("You hit CPU's Carrier!");
				CPUlocations[row][column].setText("HIT"); // sets button to hit
				CPUlocations[row][column].setEnabled(false); // disables button
				CPUlocations[row][column].setForeground(Color.RED);
				carrierCP.spacesLeft -= 1; // subtracts space
				if (carrierCP.spacesLeft == 0) { // if no spaces left (sunk)
					infoLabel.setText("You sank CPU's Carrier!");
					carrierCP.sunk = true; // sets obj sunk to true
					showSunk(5, 1); // updates buttons

				}
			} else if (CPUtextLoc[row][column] == 4) { // same as above for ship
														// id 4
				infoLabel.setText("You hit CPU's Battleship!");
				CPUlocations[row][column].setText("HIT");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setForeground(Color.RED);
				battleshipCP.spacesLeft -= 1;
				if (battleshipCP.spacesLeft == 0) {
					infoLabel.setText("You sank CPU's Battleship!");
					battleshipCP.sunk = true;
					showSunk(4, 1);

				}
			} else if (CPUtextLoc[row][column] == 3) { // same as above for ship
														// id 3
				infoLabel.setText("You hit CPU's Cruiser!");
				CPUlocations[row][column].setText("HIT");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setForeground(Color.RED);
				cruiserCP.spacesLeft -= 1;
				if (cruiserCP.spacesLeft == 0) {
					infoLabel.setText("You sank CPU's Cruiser!");
					cruiserCP.sunk = true;
					showSunk(3, 1);

				}
			} else if (CPUtextLoc[row][column] == 2) { // same as above for ship
														// id 2
				infoLabel.setText("You hit CPU's Destroyer!");
				CPUlocations[row][column].setText("HIT");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setForeground(Color.RED);
				destroyerCP.spacesLeft -= 1;
				if (destroyerCP.spacesLeft == 0) {
					infoLabel.setText("You sank CPU's Destroyer!");
					destroyerCP.sunk = true;
					showSunk(2, 1);

				}
			} else if (CPUtextLoc[row][column] == 1) { // same as above for ship
														// id 1
				infoLabel.setText("You hit CPU's Submarine!");
				CPUlocations[row][column].setText("HIT");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setForeground(Color.RED);
				submarineCP.spacesLeft -= 1;
				if (submarineCP.spacesLeft == 0) {
					infoLabel.setText("You sank CPU's Submarine!");
					submarineCP.sunk = true;
					showSunk(1, 1);

				}
			} else if (CPUtextLoc[row][column] == 0) {
				infoLabel.setText("You missed!");
				CPUlocations[row][column].setText("O");
				CPUlocations[row][column].setEnabled(false);
			}
			CPUfire();
		}

	}

	public void CPUfire() { // cpu picks location to shoot

		if (!disable) { // will not activate if buttons disabled

			while (true) {
				cpuAI();
				if (!((locations[row2][column2].getText().equals("HIT"))
						|| (locations[row2][column2].getText().equals("O"))
						|| (locations[row2][column2].getText().equals("SUNK"))))
					break;
			}

			if (textLoc[row2][column2] == 5) { // hit ship ID 5
				infoLabel2.setText("CPU hit your Carrier!");
				locations[row2][column2].setText("HIT");
				CPUlocations[row][column].setForeground(Color.RED);
				carrierPL.spacesLeft -= 1; // subtracts a space remaining
											// from Ship
				if (carrierPL.spacesLeft == 0) { // if no spaces remaining
					infoLabel2.setText("CPU sank your Carrier!");
					carrierPL.sunk = true; // sets ship object to sunk
					showSunk(5, 0); // update buttons to show sunken ship

				}
			} else if (textLoc[row2][column2] == 4) { // same as above for
														// ship ID 4
				infoLabel2.setText("CPU hit your Battleship!");
				locations[row2][column2].setText("HIT");
				CPUlocations[row][column].setForeground(Color.RED);
				battleshipPL.spacesLeft -= 1;
				if (battleshipPL.spacesLeft == 0) {
					infoLabel2.setText("CPU sank your Battleship!");
					battleshipPL.sunk = true;
					showSunk(4, 0);

				}
			} else if (textLoc[row2][column2] == 3) {// same as above for
														// ship ID 3
				infoLabel2.setText("CPU hit your Cruiser!");
				locations[row2][column2].setText("HIT");
				CPUlocations[row][column].setForeground(Color.RED);
				cruiserPL.spacesLeft -= 1;
				if (cruiserPL.spacesLeft == 0) {
					infoLabel2.setText("CPU sank your Cruiser!");
					cruiserPL.sunk = true;
					showSunk(3, 0);

				}
			} else if (textLoc[row2][column2] == 2) {// same as above for
														// ship ID 2
				infoLabel2.setText("CPU hit your Destroyer!");
				locations[row2][column2].setText("HIT");
				CPUlocations[row][column].setForeground(Color.RED);
				destroyerPL.spacesLeft -= 1;
				if (destroyerPL.spacesLeft == 0) {
					infoLabel2.setText("CPU sank your Destroyer!");
					destroyerPL.sunk = true;
					showSunk(2, 0);

				}
			} else if (textLoc[row2][column2] == 1) {// same as above for
														// ship ID 2
				infoLabel2.setText("CPU hit your Submarine!");
				locations[row2][column2].setText("HIT");
				CPUlocations[row][column].setForeground(Color.RED);
				submarinePL.spacesLeft -= 1;
				if (submarinePL.spacesLeft == 0) {
					infoLabel2.setText("CPU sank your Submarine!");
					submarinePL.sunk = true;
					showSunk(1, 0);

				}
			} else if (textLoc[row2][column2] == 0) {
				infoLabel2.setText("CPU missed!");
				locations[row2][column2].setText("O");
				locations[row2][column2].setEnabled(false);
			}
		}
	}

	public void cpuAI() {

		if (difficulty == 1) {
			// picks random spot to fire
			row2 = rand.nextInt(8);
			column2 = rand.nextInt(8);
		} else if (difficulty == 2) {
			spotfound = false;
			for (int x = 0; x < CPUlocations[1].length; x++) {
				for (int y = 0; y < CPUlocations[2].length; y++) {
					if (locations[x][y].getText().equals("HIT")) {
						int counter = 0;
						boolean hold = true;
						boolean locked[] = { false, false, false, false };
						do {
							int random = rand.nextInt(4);
							while (hold) {
								if (locked[random] == true) {
									random = rand.nextInt(4);
								} else
									hold = false;
							}

							counter++;

							if ((random == 0) && (x - 1 != -1)) {
								if (!((locations[x - 1][y].getText().equals("HIT"))
										|| (locations[x - 1][y].getText().equals("O"))
										|| (locations[x - 1][y].getText().equals("SUNK")))) {
									row2 = x - 1;
									column2 = y;
									spotfound = true;
								} else
									locked[0] = true;

							}

							if ((random == 1) && (x + 1 != 8) && (!spotfound)) {
								if (!((locations[x + 1][y].getText().equals("HIT"))
										|| (locations[x + 1][y].getText().equals("O"))
										|| (locations[x + 1][y].getText().equals("SUNK")))) {
									row2 = x + 1;
									column2 = y;
									spotfound = true;
								} else
									locked[1] = true;
							}

							if ((random == 2) && (y - 1 != -1) && (!spotfound)) {
								if (!((locations[x][y - 1].getText().equals("HIT"))
										|| (locations[x][y - 1].getText().equals("O"))
										|| (locations[x][y - 1].getText().equals("SUNK")))) {
									row2 = x;
									column2 = y - 1;
									spotfound = true;
								} else
									locked[2] = true;
							}

							if ((random == 3) && (y + 1 != 8) && (!spotfound)) {
								if (!((locations[x][y + 1].getText().equals("HIT"))
										|| (locations[x][y + 1].getText().equals("O"))
										|| (locations[x][y + 1].getText().equals("SUNK")))) {
									row2 = x;
									column2 = y + 1;
									spotfound = true;
								} else
									locked[3] = true;
							}

						} while ((!spotfound) && (counter < 4));
					}
					if (spotfound)
						break;
				}
				if (spotfound)
					break;
			}
			if (!spotfound) {
				row2 = rand.nextInt(8);
				column2 = rand.nextInt(8);
			}

		} else if (difficulty == 3) {
			while (true) {
				row2 = rand.nextInt(8);
				column2 = rand.nextInt(8);
				if (textLoc[row2][column2] != 0)
					break;
			}
		}

	}

	public void showSunk(int ID, int who) {
		if (who == 0) { // player ships
			for (int x = 0; x < locations[1].length; x++) {
				for (int y = 0; y < locations[2].length; y++) {
					if (textLoc[x][y] == ID) // finds sunken ship
						locations[x][y].setText("SUNK"); // button text SUNK
				}
			}
			CheckWinLose(); // checks if game over

		} else if (who == 1) { // cpu ships
			for (int x = 0; x < CPUlocations[1].length; x++) {
				for (int y = 0; y < CPUlocations[2].length; y++) {
					if (CPUtextLoc[x][y] == ID) { // find sunken ship
						CPUlocations[x][y].setText("SUNK");
						CPUlocations[x][y].setOpaque(true);
						// updates colour to show ship
						if (CPUtextLoc[x][y] == 1) {
							CPUlocations[x][y].setBackground(Color.MAGENTA);
						} else if (CPUtextLoc[x][y] == 2) {
							CPUlocations[x][y].setBackground(Color.ORANGE);
						} else if (CPUtextLoc[x][y] == 3) {
							CPUlocations[x][y].setBackground(Color.GREEN);
						} else if (CPUtextLoc[x][y] == 4) {
							CPUlocations[x][y].setBackground(Color.CYAN);
						} else if (CPUtextLoc[x][y] == 5) {
							CPUlocations[x][y].setBackground(Color.YELLOW);
						}
					}
				}

			}
			CheckWinLose(); // checks if game over
		}

	}

	public void CheckWinLose() { // checks if user has won or lost (called when
									// a ship is sunk)
		if ((carrierCP.sunk) && (battleshipCP.sunk) && (cruiserCP.sunk) && (submarineCP.sunk) && (destroyerCP.sunk)) {
			// all CPU ships sunk
			// win
			infoLabel2.setVisible(false);
			// resize and name label
			infoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			infoLabel.setBounds(0, 440, 825, 25);
			infoLabel.setText("You win!!");
			disable = true; // disable buttons
			close.setEnabled(true); // turns on close button
			close.setBounds(362, 465, 100, 25);
		}

		if ((!disable) && (carrierPL.sunk) && (battleshipPL.sunk) && (cruiserPL.sunk) && (submarinePL.sunk)
				&& (destroyerPL.sunk)) { // all player ship sunk
			// lose
			infoLabel2.setVisible(false);
			// resize and name label
			infoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			infoLabel.setBounds(0, 440, 825, 25);
			infoLabel.setText("You lose!!");
			disable = true; // disable buttons
			close.setEnabled(true); // turns on close button
			close.setBounds(362, 465, 100, 25);
		}

	}

	// Overrides
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
