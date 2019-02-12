package edu.neumont.csc150.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Drawing extends JPanel implements ActionListener {
	//private JButton button = new JButton("Click me!");
	private Timer timer = new Timer(30, this);
	
	private List<Ball> balls = null;
	
	public Drawing() {
		this.setBackground(Color.MAGENTA);
		//this.add(button);
		//button.addActionListener(this);
		
	}
	
	public void startAnimation() {
		balls = BallFactory.newBalls(10, 10, 200, 10, 200, 0, this.getWidth(), 0, this.getHeight(), 10, 60, 10, 60);
		//timer.start();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(balls != null) {
			for(Ball ball : balls) {
				g.setColor(ball.getColor());
				g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.timer) {
			if(balls != null) {
				for(Ball ball : balls) {
					ball.setX(ball.getX() + ball.getxVelocity());
					ball.setY(ball.getY() + ball.getyVelocity());
					ball.detectWallCollision(this.getWidth(), this.getHeight(), 0, 0);
				}
			}
			this.repaint();
		}
		else if(e.getSource() instanceof JMenuItem) {
			JMenuItem sourceMenuItem = (JMenuItem) e.getSource();
			if(sourceMenuItem.getText().equals("Start")) {
				this.timer.start();
			}
			else {
				this.timer.stop();
			}
		}
	}
}
