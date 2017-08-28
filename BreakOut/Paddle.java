package BreakOut;
import java.awt.Color;
import java.awt.Graphics;

import BreakOut.GameConstants;

public class Paddle  {
	
	 //private int xSpeed;
	 
	 protected int paddleXPos;
	 protected int paddleYPos;
	 private int paddleWidth;
	 private int paddleHeight;

	    // Constructor
	    public Paddle(int paddleInitialPositionX, int paddleInitialPositionY, int paddleWidth, int paddleHeight) {
	    	this.paddleXPos = paddleInitialPositionX;
			this.paddleYPos = paddleInitialPositionY;
			this.paddleWidth = paddleWidth;
			this.paddleHeight = paddleHeight;			
	    }

	    // Draws the paddle
	    public void draw(Graphics g) {
	        g.setColor(Color.GREEN);
	        g.fillRect(paddleXPos,paddleYPos,paddleWidth,paddleHeight);
	    }
	    
	    // To position the paddle in its initial position
	    public void reset() {
	    	paddleXPos = GameConstants.PADDLE_INITIAL_POSITION_X;
	    	paddleYPos = GameConstants.PADDLE_INITIAL_POSITION_Y;
	    }

	    // Checks if the ball hit the paddle
	    public boolean hitsPaddle(int ballPosX, int ballPosY,int ballRadius){
	        if ((ballPosX >= paddleXPos) && (ballPosX <= paddleXPos + paddleWidth)
	                && ((ballPosY >= paddleYPos - ballRadius) && (ballPosY <= paddleYPos + paddleHeight))) {
	            return true;
	        }
	        return false;
	    }
		
	
}
