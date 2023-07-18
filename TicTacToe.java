import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/*
 * This class creates the board and controls the logic of the game 
 */
public class TicTacToe implements ActionListener {
	
	Random turnRandomizer = new Random();	//creates a object to randomize which player goes first
	JFrame frame = new JFrame();			//creates a frame for the board
	JPanel titlePanel = new JPanel();		//creates the title panel 
	JPanel infoPanel = new JPanel();		//creates the info panel
	JPanel buttonsPanel = new JPanel();		//creates the buttons panel
	JLabel textField = new JLabel();		//creates the title text field
	JLabel infoTextField = new JLabel();	//creates the info text field
	JButton[] buttons = new JButton[10];	//creates buttons for the game and to reset	
	boolean playerTurn;						//controls players turns true=X-turn / false=O-turn
	
	//this constructor calls the method to build the board and set first player turn 
	TicTacToe (){	
		//Initializes player turn variable to false
		playerTurn = false;
		//call to the method to build the board for the game
		buildBoard();
		//call turn method to find out which player goes first
		turn();	
	}
	
	//this method creates the complete board by initializing and setting all elements above
	public void buildBoard() {
		//build frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setLayout(new BorderLayout());
		//build title text Field
		textField.setBackground(new Color(0, 0, 0));
		textField.setForeground(new Color(20, 153, 242));
		textField.setFont(new Font("Serif", Font.BOLD, 45));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		//build title panel 
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 400, 100);
		titlePanel.add(textField);
		//build info text field
		infoTextField.setBackground(new Color(0, 0, 0));
		infoTextField.setForeground(new Color(20, 153, 242));
		infoTextField.setFont(new Font("Serif", Font.BOLD, 45));
		infoTextField.setText("START");
		infoTextField.setHorizontalAlignment(JLabel.CENTER);
		infoTextField.setOpaque(true);
		//build info panel
		infoPanel.setLayout(new BorderLayout());
		infoPanel.setBounds(0, 0, 400, 100);
		infoPanel.add(infoTextField, BorderLayout.NORTH);
		//build X/O buttons
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttonsPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Serif", Font.BOLD, 70));
			buttons[i].setText("");
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		//build x/o buttons panel
		buttonsPanel.setLayout(new GridLayout(3,3));
		buttonsPanel.setBackground(new Color(0, 34, 150));	
		//build reset button
		buttons[9] = new JButton();
		buttons[9].setFont(new Font("Serif", Font.BOLD, 20));
		buttons[9].setFocusable(false);
		buttons[9].addActionListener(this);
		buttons[9].setForeground(new Color(255, 0, 0));
		buttons[9].setText("RESET");
		//add all panels and elements to frame
		infoPanel.add(buttons[9], BorderLayout.SOUTH);		
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(infoPanel, BorderLayout.SOUTH);
		frame.add(buttonsPanel);	
		frame.setVisible(true);
	}
	
	//this method controls the what happens after the buttons are clicked 
	@Override
	public void actionPerformed(ActionEvent e) {

		int count;	//counter to iterate over buttons 
		//this for loop controls the button clicks for O and X
		for(count = 0; count < 9; count++) {
			if(e.getSource() == buttons[count]) {
				//sets the button with X for player choice
				if(playerTurn) {
					if(buttons[count].getText() == ""){
						buttons[count].setForeground(new Color(255, 0, 0));
						buttons[count].setText("X");
						playerTurn = false;
						infoTextField.setText("O's Turn");
						check();	//calls check method to check if player won
					}
				}
				//sets the button with O for player choice
				else {
					if(buttons[count].getText() == ""){
						buttons[count].setForeground(new Color(0, 0, 255));
						buttons[count].setText("O");
						playerTurn = true;
						infoTextField.setText("X's Turn");
						check();	//calls check method to check if player won
					}
				}
			}
		}
		//controls the action for the reset button by reseting the board
		if(e.getSource() == buttons[9]) {	
			for(count = 0; count < 9; count++) {
				buttons[count].setBackground(new Color(0, 34, 150));
				buttons[count].setOpaque(false);
				buttons[count].setText("");
				buttons[count].setEnabled(true);
			}
			count = 0;	//resets counter 0 for new game
			turn();	//calls method to figure out who goes first
		}
	}
	
	//method figures out player turn at random
	public void turn() {
		//delays the start of the game by 1 second to display "start" in info panel then the player turn
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//sets info field and player turn based on random generated number
		if(turnRandomizer.nextInt(2) == 0) {
			playerTurn = true;
			infoTextField.setText("X's Turn");					
		}
		else {
			playerTurn = false;
			infoTextField.setText("O's Turn");				
		}
	}
	
	//method is used to create a reference point for the aspect point cut
	public boolean check() {
		return true;
	}	
	
	//this method updates the board if there is a draw
	public void draw() {
		
		int count = 0;				//counter to iterate buttons
		boolean filled = false;		//checks if all buttons are clicked

		//loop iterates to check button status
		for(count = 0; count < 9; count++) {
			if(buttons[count].getText() == "") {
				filled = false;
				count = 9;
			}
			else {
				filled = true;
			}
		}
		//if all buttons are pressed and no win then draw is declared and game is reset
		if(infoTextField.getText() != "X WINS" && infoTextField.getText() != "O WINS" && filled) {		
			
			for(int i = 0; i < 9; i++) {
				buttons[i].setEnabled(false);
			}
			infoTextField.setText("DRAW!");
		}
	}
	
	//method updates board if x wins
	public void xWins(int x, int y, int z) {
		//sets winning buttons background color to green
		buttons[x].setBackground(new Color(0, 255, 0));
		buttons[y].setBackground(new Color(0, 255, 0));
		buttons[z].setBackground(new Color(0, 255, 0));
		buttons[x].setOpaque(true);
		buttons[y].setOpaque(true);
		buttons[z].setOpaque(true);
		frame.setVisible(true);
		//sets buttons to inactive
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		infoTextField.setText("X WINS"); 
	}
	
	//method updates board if O wins
	public void oWins(int x, int y, int z) {
		//sets winning buttons background color to green		
		buttons[x].setBackground(new Color(0, 255, 0));
		buttons[y].setBackground(new Color(0, 255, 0));
		buttons[z].setBackground(new Color(0, 255, 0));
		buttons[x].setOpaque(true);
		buttons[y].setOpaque(true);
		buttons[z].setOpaque(true);	
		frame.setVisible(true);
		//sets buttons to inactive
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		infoTextField.setText("O WINS");	
	}
}
