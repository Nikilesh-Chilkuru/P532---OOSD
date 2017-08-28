package BreakOut;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import BreakOut.GameConstants;

public class GameMain {
	
	private static JFrame frame;
    private static GameManager gameManager;
    private static Dimension dim;
    // Build and run the game
    public static void main(String[] args) {
    	
       frame = new JFrame("BreakOut"); // creating a new frame
       frame.setSize(GameConstants.WINDOW_WIDTH,GameConstants.WINDOW_HEIGHT);//setting frame size
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       gameManager = new GameManager(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);// creating instance of GameManager

       frame.getContentPane().add(gameManager);// adding the GameManager instance to the frame
        
       // to center the game window on the screen
       dim = Toolkit.getDefaultToolkit().getScreenSize();
       frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        
       frame.setVisible(true);
    }

}
