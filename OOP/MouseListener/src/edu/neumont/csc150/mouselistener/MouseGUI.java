package edu.neumont.csc150.mouselistener;

import java.awt.Color;

import javax.swing.JFrame;

public class MouseGUI {
	private JFrame frame;
	private MyPanel mainPanel;
	
	public MouseGUI() {
		frame = new JFrame("Mouse GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		mainPanel = new MyPanel();
		mainPanel.setBackground(Color.white);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		
		
	}
}
