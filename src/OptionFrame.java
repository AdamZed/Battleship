package Battleship2; // package

//imports 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionFrame extends JFrame implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel label = new JLabel("CPU Difficulty:");
	private JButton easyB = new JButton("Easy");
	private JButton mediumB = new JButton("Medium");
	private JButton imposB = new JButton("Impossible");
	private JButton exit = new JButton("Exit");
	int difficulty = 2;

	public OptionFrame() {

		// alter frame, resize and position
		setTitle("Options");
		setResizable(false);
		setSize(320, 200);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		easyB.setFont(new Font("Lucida Grande", Font.PLAIN, 12));

		// alter buttons
		easyB.setBounds(122, 57, 76, 33);
		easyB.addMouseListener(this);
		easyB.setEnabled(true);
		easyB.setFocusable(false);
		getContentPane().add(easyB);
		
		mediumB.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		mediumB.setBounds(122, 90, 76, 33);
		mediumB.addMouseListener(this);
		mediumB.setEnabled(false);
		mediumB.setFocusable(false);
		getContentPane().add(mediumB);
		
		imposB.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		imposB.setBounds(122, 123, 76, 33);
		imposB.addMouseListener(this);
		imposB.setFocusable(false);
		getContentPane().add(imposB);
		
		exit.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		exit.setBounds(0, 0, 45, 28);
		exit.addMouseListener(this);
		exit.setEnabled(true);
		exit.setFocusable(false);
		getContentPane().add(exit);

		// alter label, resize and position
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		label.setLocation(0, 25);
		label.setSize(320, 15);
		label.setForeground(Color.WHITE);
		getContentPane().add(label);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void mousePressed(MouseEvent e) {
		// checks if button is clicked
		if (e.getButton() == 1) { // left click
			if ((JButton) e.getSource() == easyB) {
				difficulty = 1;
				easyB.setEnabled(false);
				mediumB.setEnabled(true);
				imposB.setEnabled(true);
			}
			if ((JButton) e.getSource() == mediumB) {
				difficulty = 2;
				easyB.setEnabled(true);
				mediumB.setEnabled(false);
				imposB.setEnabled(true);
			}
			if ((JButton) e.getSource() == imposB) {
				difficulty = 3;
				easyB.setEnabled(true);
				mediumB.setEnabled(true);
				imposB.setEnabled(false);
			}
			if ((JButton) e.getSource() == exit) // if clicked on exit button
				 setVisible(false);

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
