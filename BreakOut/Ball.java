package BreakOut;

import java.awt.Color;
import java.awt.Graphics;

import BreakOut.GameConstants;

public class Ball implements Observer{
	
	protected int ballposX ;
	protected int ballposY ;
	private int ballRadius;
	protected int ballXdir = GameConstants.BALL_SPEED_XDIR;
	protected int ballYdir = GameConstants.BALL_SPEED_XDIR;

	public Ball(int ballInitialPositionX, int ballInitialPositionY, int ballRadius) {
		this.ballposX = ballInitialPositionX;
		this.ballposY = ballInitialPositionY;
		this.ballRadius = ballRadius;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
        g.fillOval(ballposX, ballposY, ballRadius, ballRadius);
	}
	
	public void reset() {
		ballposX = GameConstants.BALL_INITIAL_POSITION_X;
		ballposY = GameConstants.BALL_INITIAL_POSITION_Y;
	}

	@Override
	public void update() {
		// to accomodate for ball movement
		ballposX += ballXdir;
		ballposY += ballYdir;
		
		// changing the directions of ball depending on which corner it is hitting		
		// left border
		if(ballposX <= 0 ){
			ballXdir = -ballXdir;
		}
					
		//top border
		if(ballposY <= 0 ){
			ballYdir = -ballYdir;
		}
					
		// right border
		if(ballposX >=780 ){
			ballXdir = -ballXdir;
		}	
		
	}

	
	

}
