package edu.neumont.csc150.mouselistener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener{

	private int x = 50, y = 50, width = 60, height = 60;
	private boolean inDraggingMode = false;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED );
		g.fillOval(x, y, width, height);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//x = e.getX() - (width / 2);
		//y = e.getY() - (height / 2);
		//this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX() >= x && e.getX() <= x + width) {
			if(e.getY() >= y && e.getY() <= y + height) {
				inDraggingMode = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		inDraggingMode = false;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(inDraggingMode) {
			x = e.getX() - (width / 2);
			y = e.getY() - (height / 2);
			this.repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//x = e.getX() - (width / 2);
		//y = e.getY() - (height / 2);
		//this.repaint();
		
	}
}
