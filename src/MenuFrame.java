package Battleship2; // package

//imports
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame implements MouseListener {

	private JFrame mainmenu = new JFrame("Battleship - Main Menu"); // main frame
	private JPanel buttons = new JPanel(); // main panel, holds buttons
	private JButton play = new JButton("Play"); // play button
	private JButton instructions = new JButton("Instructions"); // instruction button
	private JButton exit = new JButton("Exit"); //exit button
	private JButton option = new JButton();
	public OptionFrame options = new OptionFrame();
	
	public MenuFrame() {

		// alter menu variables, resize and location
		mainmenu.setResizable(false);
		mainmenu.setSize(600, 500);
		mainmenu.setLocationRelativeTo(null);

		buttons.setLayout(null);

		// alter play button, resize and position
		play.setBounds(250, 250, 100, 50);
		play.addMouseListener(this);
		play.setEnabled(true);
		play.setFocusable(false);
		
		// alter instr button, resize and position
		instructions.setBounds(250, 300, 100, 50);
		instructions.addMouseListener(this);
		instructions.setEnabled(true);
		instructions.setFocusable(false);
		
		// alter exit button, resize and position
		exit.setBounds(250, 350, 100, 50);
		exit.addMouseListener(this);
		exit.setEnabled(true);
		exit.setFocusable(false);
		
		exit.setBounds(250, 350, 100, 50);
		exit.addMouseListener(this);
		exit.setEnabled(true);
		exit.setFocusable(false);
		option.setToolTipText("Options");
		
		option.setBounds(560,0,40,40);
		option.addMouseListener(this);
		option.setEnabled(true);
		option.setFocusable(false);
		option.setIcon(new ImageIcon(MenuFrame.class.getResource("/Battleship2/gear30x.png")));

		//add buttons to JPanel
		buttons.add(play);
		buttons.add(instructions);
		buttons.add(exit);
		buttons.add(option);
		mainmenu.getContentPane().add(buttons); // add panel to button

		//background image
		JLabel battleshipIMG = new JLabel("");
		battleshipIMG.setIcon(new ImageIcon(MenuFrame.class.getResource("/Battleship2/battleship.png")));
		battleshipIMG.setBounds(0, 0, 600, 500);
		buttons.add(battleshipIMG);
		
		// show menu and set to terminate on close
		mainmenu.setVisible(true);
		mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// checks if user clicks button
		if (e.getButton() == 1) { // left click
			if ((JButton) e.getSource() == play) {
				launchGame(); // if clicked play button, launch game window
			} else if ((JButton) e.getSource() == instructions) {
				showInst(); // if clicked inst button, launch inst window
			} else if ((JButton) e.getSource() == exit) {
				System.exit(0); // terminate if user exits
			} else if ((JButton) e.getSource() == option) {
				showOps();
			}
		}

	}

	private void launchGame() {
		new GameFrame(options.difficulty); // creates new Battleship frame
	}

	private void showInst() {
		new InstructionFrame(); // creates new instruction frame
	}
	
	private void showOps() {
		options.setVisible(true);
	}

	// Overrides
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
