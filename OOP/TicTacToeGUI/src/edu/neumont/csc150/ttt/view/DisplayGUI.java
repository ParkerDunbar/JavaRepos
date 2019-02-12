package edu.neumont.csc150.ttt.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.neumont.csc150.ttt.controller.Gameplay;

public class DisplayGUI implements ActionListener{
	private JFrame window;
	private JPanel mainPanel;
	public static JButton topLeft, topCenter, topRight, midLeft, midCenter, midRight, botLeft, botCenter, botRight;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem newGame, saveGame, loadGame, quitGame;
	

	public void GUIMain() {
		window = new JFrame("Tic Tac Toe");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
		window.setSize(1000, 1000);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}

	private void initGUI() {
		newGame = new JMenuItem("New Game");
		saveGame = new JMenuItem("Save Game");
		loadGame = new JMenuItem("Load Game");
		quitGame = new JMenuItem("Quit Game");
		menu = new JMenu("Game");
		menuBar = new JMenuBar();
		
		topLeft = new JButton();
		topCenter = new JButton();
		topRight = new JButton();
		midLeft = new JButton();
		midCenter = new JButton();
		midRight = new JButton();
		botLeft = new JButton();
		botCenter = new JButton();
		botRight = new JButton();
		
		
		GridLayout gridLayout = new GridLayout(3, 3, 0, 0);
		mainPanel = new JPanel();
		mainPanel.setLayout(gridLayout);
		
		menu.add(newGame);
		menu.add(saveGame);
		menu.add(loadGame);
		menu.add(quitGame);
		menuBar.add(menu);
		window.setJMenuBar(menuBar);
		
		mainPanel.add(topLeft);
		mainPanel.add(topCenter);
		mainPanel.add(topRight);
		
		mainPanel.add(midLeft);
		mainPanel.add(midCenter);
		mainPanel.add(midRight);
		
		mainPanel.add(botLeft);
		mainPanel.add(botCenter);
		mainPanel.add(botRight);
		
		
		topLeft.addActionListener(this);
		topCenter.addActionListener(this);
		topRight.addActionListener(this);
		
		midLeft.addActionListener(this);
		midCenter.addActionListener(this);
		midRight.addActionListener(this);
		
		botLeft.addActionListener(this);
		botCenter.addActionListener(this);
		botRight.addActionListener(this);
		
		newGame.addActionListener(this);
		saveGame.addActionListener(this);
		loadGame.addActionListener(this);
		quitGame.addActionListener(this);
		
		window.getContentPane().add(mainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame) {
			Gameplay.newGame();
		}
		
		if(e.getSource() == quitGame) {
			System.exit(0);
		}
		
		if(e.getSource() == topLeft) {
			try {
				Gameplay.takeSquare(0, 1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(e.getSource() == topLeft) {
			if(topLeft.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					topLeft.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					topLeft.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		else if(e.getSource() == topCenter) {
			if(topCenter.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					topCenter.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					topCenter.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		else if(e.getSource() == topRight) {
			if(topRight.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					topRight.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					topRight.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		
		if(e.getSource() == midLeft) {
			if(midLeft.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					midLeft.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					midLeft.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		else if(e.getSource() == midCenter) {
			if(midCenter.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					midCenter.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					midCenter.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		else if(e.getSource() == midRight) {
			if(midRight.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					midRight.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					midRight.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		
		if(e.getSource() == botLeft) {
			if(botLeft.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					botLeft.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					botLeft.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		else if(e.getSource() == botCenter) {
			if(botCenter.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					botCenter.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					botCenter.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
		else if(e.getSource() == botRight) {
			if(botRight.getText() == "") {
				if(Gameplay.whoseTurnIsIt == Gameplay.oplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.xplayer;
					botRight.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
				else if(Gameplay.whoseTurnIsIt == Gameplay.xplayer) {
					Gameplay.whoseTurnIsIt = Gameplay.oplayer;
					botRight.setText(Gameplay.whoseTurnIsIt.getWhoAmI());
					Gameplay.checkWin();
				}
			}
			else {
				JOptionPane.showMessageDialog(this.window, "That space is already taken!");
			}
		}
		
	}
	
	public void displayPlayerXWin() {
		JOptionPane.showMessageDialog(this.window, "Player X has won!");
		newGame();
	}
	
	public void displayPlayerOWin() {
		JOptionPane.showMessageDialog(this.window, "Player O has won!");
		newGame();
	}
	
	public void displaySpaceTaken() {
		JOptionPane.showMessageDialog(this.window, "That space is already taken!");
	}
	
	public void newGame() {
		topLeft.setText("");
		topCenter.setText("");
		topRight.setText("");
		
		midLeft.setText("");
		midCenter.setText("");
		midRight.setText("");
		
		botLeft.setText("");
		botCenter.setText("");
		botRight.setText("");
	}
	
}
