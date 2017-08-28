package BreakOut;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick{
	public int bricks[][];
	protected int brickWidth;
	protected int brickHeight;
	protected int numRows;
	protected int numCols;
	
	public Brick(int num_row, int num_col,int width, int height){
		
		this.brickWidth = width;
		this.brickHeight = height;
		this.numRows = num_row;
		this.numCols = num_col;
			
		bricks = new int[numRows][numCols];
		
		for(int i=0; i < numRows; i++){
			for(int j=0; j < numCols;j++){
				bricks[i][j] = 1; //1 if brick is not yet touched and zero otherwise
			}
		}
		
		
	}
	
	public void draw(Graphics2D g){
		for(int i=0; i < numRows; i++){
			for(int j=0; j <numCols;j++){
			if(bricks[i][j] > 0){
				
				// drawing bricks
				g.setColor(Color.CYAN);
				g.fillRect(j*brickWidth+50, i*brickHeight+70, brickWidth, brickHeight);
				
				// drawing borders between bricks
				g.setStroke(new BasicStroke(4));
				g.setColor(Color.black);
				g.drawRect(j*brickWidth+50, i*brickHeight+70, brickWidth, brickHeight);
							
			}
				
			}
		}
		
	}
	
	public void setBrickValue(int value, int row, int col){
		bricks[row][col] = value;
	}

	public void reset() {
		
		for(int i=0; i < numRows; i++){
			for(int j=0; j < numCols;j++){
				bricks[i][j] = 1; //1 if brick is not yet touched and zero otherwise
			}
		}
		
	}


}

