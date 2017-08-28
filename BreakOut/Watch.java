package BreakOut;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Watch extends JComponent implements Observer, ActionListener{
	
	
	  protected int seconds =0;
	  protected int minutes = 0;
	  protected Timer t;
	  private int timerStartFlag = 0;
	  public Watch() { 
	    t = new Timer(1000, this);	   
	  }
	  
	  @Override
		public void actionPerformed(ActionEvent e) {
		  
			if(seconds == 59){
				minutes++;
				seconds = 0;
			}
			else{
			seconds++;
			}
			 	  
		}
	
	  public  void draw(Graphics g){
		  
		  g.setColor(Color.GREEN);
	      g.setFont(new Font("serif", Font.PLAIN,15));
	      g.drawString((" mm"+ "  :   "+ " ss"), 30, 30);
		  
		  g.setColor(Color.GREEN);
	      g.setFont(new Font("serif", Font.BOLD,40));
	      g.drawString((""+minutes+ " : "+ seconds), 30, 60);
		  
		}

	  public void reset() {
	    	this.minutes = 0;
	    	this.seconds = 0;
	    	this.timerStartFlag = 0;
	    	this.t.stop();
	    }
	    
	


	@Override
	public void update(){
		if(timerStartFlag <= 0){
			t.start();
			timerStartFlag++;
		}
	
	}

}
