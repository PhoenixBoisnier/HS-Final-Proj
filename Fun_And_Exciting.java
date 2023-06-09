
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class Fun_And_Exciting extends JFrame implements KeyListener {
	

	  int a = 0;
      int b = 0;
      int c = 200;
      int d = 0;
      boolean up = false;
      int ammo = 100;
      int reloads = 4;
      int hits = 0;
      int health = 3;
      int hisHealth = 3;
      ArrayList<Shot> ss = new ArrayList<Shot>();
      ArrayList<Shot> sss = new ArrayList<Shot>();


      
      
      public class Shot {

    		int a = 0;
    		int b = 0;
    		
    		public Shot(int x,int y){
    			a = x;
    			b = y;

    			update();
    		}
    		public Shot(int x, int y, boolean v){
    			a = x; 
    			b = y;
    		}
    		
    		public void update(){
    			a+=10;
    			if(a>400){
    				a+=100;
    			}
    		}
    		public void antiupdate(){
    			a-=10;
    			if(a<0){
    				a-=100;
    			}
    		}
    		public int getX(){
    			return a;
    		}
    		public int getY(){
    			return b;
    		}
    	}
      
      
  	

	
	public static void main(String[] args)
	{
		Fun_And_Exciting pg = new Fun_And_Exciting();
		
		pg.setVisible(true);
		
	}

	Fun_And_Exciting()
	{
		
		 JPanel content = new JPanel();              // Create content panel.
	        content.setLayout(new BorderLayout());
	        addKeyListener(this);
	        Smile drawing = new Smile();            
	        content.add(drawing, BorderLayout.CENTER);  // Put in expandable center.
	        
	        this.setContentPane(content);
	        this.setTitle("Smile");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.pack();                                // Finalize window layout
	        this.setLocationRelativeTo(null); 
	        
	        
	        
	        
	}
	
	
	public class Smile extends JComponent
	{
		private static final int BORDER = 8;  // Border in pixels.
	    
	    //===================================================== constructor
	    Smile() {
	        this.setPreferredSize(new Dimension(400, 400));  // size
	        
	        
	    }
	    
	    
	  
	    
	    //================================================== paintComponent

		/* This is where your code will go.  It changes what is  shown on the screen.
 		g is the graphics object and its fun methods include setColor and fillOval, fillRect, and more.
		This is my code for the start of my face.  Note the good looks. */

	    @Override public void paintComponent(Graphics g) {
	        int w = getWidth();
	        int h = getHeight();

	        if(hisHealth<=0){
	        	if(c>=200&&c<=220){
	        	if(d>=0&&d<=20){
	        		hisHealth = 3;
	        		}
	        	}
	        }
	        
	        if(health >= 0 && health<=-19){
	        	System.out.println("Succesful hits: "+hits);
	        	health-=20;
	        }
	    /*

		YOUR CODE GOES HERE.
		g.setColor(Color.whatever); changes the ink color
		g.fillRect(int x, int y, int width, int height); draws a rectangle
		Have fun!
		
		*/ 
	      
	        g.setColor(Color.BLACK);
	        g.fillRect(0, 0, 400, 400);
	        if(hisHealth>0){g.setColor(Color.WHITE);}
	        g.fillRect(390, b, 10, 30);
	        g.setColor(Color.RED);
	        for(int q = 0; q<health; q++){
	        	g.fillRect(0+(10*q), 0, 8, 8);
	        }
	        g.setColor(Color.DARK_GRAY);
	        for(int q = 0; q<hisHealth; q++){
	        	g.fillRect(370+(10*q), 0, 8, 8);
	        }
	       if(hisHealth>0){
	    	   if(!up){
	       
	        	b+=5;}
	        else if(up) {
	        	b-=5;}
	        if(b+30>=400){
	        	up = true;
	        }
	        if(b<=0){
	        	up = false;
	        }}
	        try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        this.repaint();
	        if(hisHealth <= 0){
	        	g.setColor(Color.RED);
	        	g.fillRect(0, 200, 20, 20);
	        }
	        
	        g.setColor(Color.BLUE);
	        g.fillRect(d, c, 15, 5);
			g.setColor(Color.GREEN);
			
	        for(int q = 0; q<ss.size(); q++){
	        	g.fillRect(ss.get(q).getX(), ss.get(q).getY(), 3, 2);
	        	if(ss.get(q).getX()+3>=390){
	        			if(ss.get(q).getY()>=b&&ss.get(q).getY()<=b+30){
	        				System.out.println("Target hit."); 
	        				System.out.println("His health " +hisHealth);
	        				hits++;
	        				hisHealth--;
	        		}
	        	}
	        	ss.get(q).update();
	        	if(ss.get(q).getX()>410){
	        		ss.remove(q);
	        	}
	        }
	        if(hisHealth>0){if((int)(Math.random()*4+1)==1){
	        	sss.add(new Shot((390-3), (b+15), false));
	        }
	        for(int q = 0; q<sss.size(); q++){
	        	g.setColor(Color.RED);
	        	g.fillRect(sss.get(q).getX(), sss.get(q).getY(), 3, 2);
	        	sss.get(q).antiupdate();
	        	if(sss.get(q).getX()>d&&sss.get(q).getX()<d+15){
	        		if(sss.get(q).getY()>=c&&sss.get(q).getY()<=c+5){
	        		health--;
	        		}
	        	}
	        	if(sss.get(q).getX()<0){
	        		sss.remove(q);
	        	}
	        }

	        
	    }
	        
	        
	    }

	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		if(health>0){
		if(arg0.getKeyCode()==32){
			if(ammo>0){
				ss.add(new Shot(d+15, c));
				ammo--;
				System.out.println(ammo);
				}
			if(ammo<=0){
				System.out.println("Reloading...");
				ammo--;
			}
			if(ammo==-10){
				System.out.println("Succesful hits: "+hits);
				if(reloads>0){
					ammo=100;
					reloads--;
					System.out.println(reloads + " reloads left.");
					}
			}
		}
		if(arg0.getKeyCode()==38&&c>0){
			c-=3;
		}
		if(arg0.getKeyCode()==39&&d<385){
			d+=3;
		}
		if(arg0.getKeyCode()==37&&d>0){
			d-=3;
		}
		if(arg0.getKeyCode()==40&&c<395){
			c+=3;
		}
		//System.out.println("x: "+d);
		//System.out.println("y: "+c);
		this.repaint();
	}}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}