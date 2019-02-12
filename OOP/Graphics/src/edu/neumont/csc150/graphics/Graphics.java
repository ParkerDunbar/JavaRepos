package edu.neumont.csc150.graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Graphics {
	
	public static void addMenu(JFrame frame, Drawing drawingPanel) {
		JMenuItem startsAnimation = new JMenuItem("Start");
		startsAnimation.addActionListener(drawingPanel);
		JMenuItem stopsAnimation = new JMenuItem("Stop");
		stopsAnimation.addActionListener(drawingPanel);
		JMenu menu = new JMenu("Animation");
		JMenuBar menuBar = new JMenuBar();
		
		menu.add(startsAnimation);
		menu.add(stopsAnimation);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Drawing drawingPanel = new Drawing();
		frame.getContentPane().add(drawingPanel);
		addMenu(frame, drawingPanel);
		frame.setVisible(true);
		Thread.sleep(1000);
		drawingPanel.startAnimation();
	}

}
