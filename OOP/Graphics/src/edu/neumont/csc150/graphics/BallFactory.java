package edu.neumont.csc150.graphics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallFactory {
	private static Random gen = new Random();
	
	public static List<Ball> newBalls(int howMany, int minWidth, int maxWidth, int minHeight, int maxHeight,
			int minX, int maxX, int minY, int maxY,
			int minXV, int maxXV, int minYV, int maxYV) {
		
		List<Ball> balls = new ArrayList<>();
		
		for(int i=0; i<howMany;i++) {
			balls.add(newBall(minWidth, maxWidth, minHeight, maxHeight,
					minX, maxX, minY, maxY, minXV, maxXV, minYV, maxYV));
		}
		return balls;
	}
	
	public static Ball newBall(int minWidth, int maxWidth, int minHeight, int maxHeight,
			int minX, int maxX, int minY, int maxY,
			int minXV, int maxXV, int minYV, int maxYV) {
		
		Ball ball = new Ball();
		ball.setWidth(gen.nextInt(maxWidth - minWidth) + minWidth);
		ball.setHeight(gen.nextInt(maxHeight - minHeight) + minHeight);
		ball.setX(gen.nextInt(maxX - minX) + minX);
		ball.setY(gen.nextInt(maxY - minY) + minY);
		ball.setxVelocity(gen.nextInt(maxXV - minXV) + minXV);
		ball.setyVelocity(gen.nextInt(maxYV - minYV) + minYV);
		ball.setColor(new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255)));
		return ball;
	}
}
