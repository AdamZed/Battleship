package Battleship2; // package

//imports 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionFrame implements MouseListener { // instruction frame
	private JFrame frame = new JFrame("Instructions"); // main frame container
	private JLabel label = new JLabel(); // line 1 label
	private JLabel label2 = new JLabel(); // line 2 label
	private JButton exit = new JButton("Close Instructions"); // button to close frame

	public InstructionFrame() {

		// alter frame, resize and position
		frame.setResizable(false);
		frame.setSize(320, 200);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		
		// alter exit button, resize and position
		exit.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		exit.setBounds(100, 120, 120, 40);
		exit.addMouseListener(this);
		exit.setEnabled(true);
		exit.setFocusable(false);
		frame.getContentPane().add(exit);
		
		// alter label, resize and position
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		label.setLocation(0, 40);
		label.setSize(320, 15);
		label.setText("Players take turns firing a shot to attack enemy ships.");
		label.setForeground(Color.WHITE);
		frame.getContentPane().add(label);
		
		// alter label2, resize and position
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		label2.setLocation(0, 60);
		label2.setSize(320, 15);
		label2.setText("The first player to sink all opposing ships wins.");
		label2.setForeground(Color.WHITE);
		frame.getContentPane().add(label2);

		// set frame visible and dispose contents on close
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void mousePressed(MouseEvent e) {
		//checks if button is clicked
		if (e.getButton() == 1) { // left click
			if ((JButton) e.getSource() == exit) // if clicked on exit button
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); // close window

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
	public void mouseReleased(MouseEvent arg0) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

}
