import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener{
	//handles drawing animation
	Timer animationTimer; 
	Enemy e;
	Ball b;
	Ball2[] obj = new Ball2[10];

	

	public void paint(Graphics g) {
		
		super.paintComponent(g);
		
		
		//call paint methods of objects
		e.paint(g);
		b.paint(g);
		
		int ax = e.getX();
		int ay = e.getY();
		
		for(Ball2 obje : obj) { 
			obje.update(ax, ay);	
			obje.paint(g);
			
			
		} 
		
		
		
	} 
	
	
	public MainPanel() {
		
		//Create a JFrame Object
		JFrame f = new JFrame("Example Drawing");
		
		
		f.setSize(800,600); //width and height
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		f.add(this);
		
		
		animationTimer = new Timer(16, this);
		
		
		animationTimer.start();
		
		
		
		e = new Enemy();
		
		b = new Ball();
		
		for ( int i = 0; i < obj.length; i++ ) {
			obj[i] = new Ball2();
		}

		
		f.setVisible(true);
		
		
		
	}
	
	public void update() {
		//calls collide
		for ( int i = 0; i < obj.length; i++ ) {
			b.collide(obj[i]);
		}
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		update();

		repaint();
		
	}
	
	
	
}
