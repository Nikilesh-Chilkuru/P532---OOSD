package BreakOut;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import BreakOut.GameConstants;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameManager extends JPanel implements ActionListener, Observable, KeyListener{
	
	private Ball ball;
	private Paddle paddle;
	private Brick brick;
	private Watch watch;
	private List<Observer> observers = new ArrayList<Observer>();
	private int timeDelay = 7;
	private boolean play = false;
	private int totalBricks;
	private int score;
	private Timer timer;
	
	public  GameManager(int width, int height){
		this.setSize(width, height);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		this.totalBricks = GameConstants.NUM_ROWS * GameConstants.NUM_COLUMNS;
		this.score = 0;
		
		ball = new Ball(GameConstants.BALL_INITIAL_POSITION_X, GameConstants.BALL_INITIAL_POSITION_Y, GameConstants.BALL_RADIUS);
		paddle = new Paddle(GameConstants.PADDLE_INITIAL_POSITION_X, GameConstants.PADDLE_INITIAL_POSITION_Y, GameConstants.PADDLE_WIDTH,GameConstants.PADDLE_HEIGHT);
		brick = new Brick(GameConstants.NUM_ROWS,GameConstants.NUM_COLUMNS,GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT);
		watch = new Watch();
		addKeyListener(this);
		register(ball);
		register(watch);		
		timer = new Timer(timeDelay,this);
		timer.start();
	}
	
	public void paint(Graphics g){
			
			//Setting  background
			g.setColor(Color.black);
			g.fillRect(1, 1, 800, 800);
			
			//Setting Borders to the frame
			g.setColor(Color.yellow);
			g.fillRect(0,0,2,800);
			g.fillRect(0,1,800,3);
			g.fillRect(792,0,2,800);
			
			// Displaying scores
			g.setColor(Color.WHITE);
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString("Score : "+score, 600, 50);	
			
			//drawing ball
			ball.draw(g);
			
			//drawing paddle
			paddle.draw(g);
			
			//drawing bricks
			brick.draw((Graphics2D)g);
			
			//drawing watch
			watch.draw(g);
			
			if(totalBricks <= 0){
				play = false;
				watch.reset();
				removeRegister(ball);
				removeRegister(watch);
				
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD,30));
				g.drawString("You Won   Score: "+score, 350, 400);
				
				g.setFont(new Font("serif", Font.BOLD,20));
				g.drawString("Press Space to Restart ", 350, 450);
				
			}
			
			
			if(ball.ballposY > 720 ){
				play = false;
				watch.reset();
				removeRegister(ball);
				removeRegister(watch);
				
				
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD,30));
				g.drawString("Game Over, Score : "+score, 350, 400);
				
				g.setFont(new Font("serif", Font.BOLD,20));
				g.drawString("Press Space to Restart ", 350, 450);
				score = 0;
				
				
			}
			
			g.dispose();
			
			
			
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ball movement 
           if(play){
        	   notifyObservers();
			// to detect intersection of ball and paddle
        	   if(paddle.hitsPaddle(ball.ballposX,ball.ballposY,GameConstants.BALL_RADIUS)){
        		   ball.ballYdir = -ball.ballYdir;				
        	   }
			
			  A:for(int i=0; i < brick.numRows; i++){
					for(int j=0; j< brick.numCols; j++){
						if(brick.bricks[i][j] > 0 ){
							int brickX = j*brick.brickWidth + 50;
							int brickY = i*brick.brickHeight + 70;
							int brickWidth = brick.brickWidth;
							int brickHeight = brick.brickHeight;
							
							Rectangle rect = new Rectangle(brickX,brickY, brickWidth, brickHeight);
							Rectangle ballRect = new Rectangle(ball.ballposX,ball.ballposY,40,40);
							Rectangle brickRect = rect;
							
							if(ballRect.intersects(brickRect)){
							
								brick.setBrickValue(0, i, j);
								totalBricks--;
								score += 5;
							
							
								if(ball.ballposX+39 <= brickRect.x || ball.ballposX+1 >= brickRect.x + brickRect.width ){
									ball.ballXdir = -ball.ballXdir;
								}
								else{
									ball.ballYdir = -ball.ballYdir;
								}
								break A;
							}
							
						}
					}
					
				}
			
			
		}
        
		repaint();		

	}

	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeRegister(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
            observer.update();
        }
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(paddle.paddleXPos >= 660){
				paddle.paddleXPos = 683;
			}else {
				moveRight();
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(paddle.paddleXPos <= 30){
				paddle.paddleXPos = 3;
			}else {
				moveLeft();
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && play == false){
			play = true;
			ball.reset();
			paddle.reset();
			watch.reset();
			brick.reset();
			score = 0;
			repaint();
			register(ball);
			register(watch);
		}
		
		
		repaint();
	}
	
	public void moveRight() {
		play = true;
		paddle.paddleXPos += 25;
	}


	public void moveLeft() {
		play = true;
		paddle.paddleXPos -= 25;
	}


	
}
