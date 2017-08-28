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
        
       frame = new JFrame("BreakOut");
       frame.setSize(GameConstants.WINDOW_WIDTH,GameConstants.WINDOW_HEIGHT);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       gameManager = new GameManager(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);

       frame.getContentPane().add(gameManager);
        
       dim = Toolkit.getDefaultToolkit().getScreenSize();
       frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        
       frame.setVisible(true);
    }

}
