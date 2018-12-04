package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import javafx.beans.Observable;

/**
 * A sample canvas that draws a rainbow of lines
 * @author MMUNSON
 */
public class BGCanvas extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(BGCanvas.class.getName());
    private int lineSize = 20;
    private Color col = null;
    private long counter = 0L;
	private static BGCanvas bgcanvas=null;
	//BGGenerationSet bgg1 =new BGGenerationSet(1,3);
	private BGGenerationSet bgg1;
	ArrayList<Stembg> slist1 = new ArrayList<>(); 
	int xin,yin;
	Graphics2D g;
    /**
     * CellAutCanvas constructor
     */
	BGCanvas() {
		
		System.out.println("Singleton class created");
	}
	
	public static BGCanvas getInstance() {
		if(bgcanvas == null) {
			bgcanvas = new BGCanvas();
		}
		return bgcanvas;
	}

	/**
	 * The UI thread calls this method when the screen changes, or in response
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {
		drawBG(g); // Our Added-on drawing
    }
	
	
	
	/**
	 * Draw the CA graphics panel
	 * @param g
	 */
	public void drawBG(Graphics g) {
		
		log.info("Drawing BG " + counter++);
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
		xin=size.width/2;
		yin=size.height;
		g2d.setColor(Color.white);
	g2d.fillRect(0, 0, size.width, size.height);
		 //bgg=new BGGenerationSet(1,3);
		g2d.setColor(Color.RED);
		g2d.drawString("Plant app",  size.width/2, size.height/2);
		Stembg s= new Stembg();
		if(bgg1!=null) {
		Iterator<Stembg> iterator = bgg1.slist1.iterator();
		int j=0;
		
		System.out.println("list size"+bgg1.slist1.size());
		while (iterator.hasNext()) {
				
				//System.out.println(s.toStringStem(iterator.next()));
				s=(iterator.next());
				g.setColor(Color.BLUE);;;
				System.out.println("data print: x1="+s.x1+" y1="+s.y1+ "  x2=" +s.x2+ " y2= " +s.y2);
				g.drawLine( s.x1, s.y1,s.x2,s.y2); 

		}	
		
		}
		
		
		//for (int j = 0; j < maxRows; j++) {
		  /* for (int i = 0; i < slist1.size(); i++) {
			   int redVal = validColor(i*5);
			   int greenVal = validColor(255-i*5);
			   int blueVal = validColor((i*5)-(i*2));
			   col = new Color(redVal, greenVal, blueVal);
			   // Draw box, one pixel less to create a black outline
			   int startx =slist1.get(i).x1;
			   int starty = slist1.get(i).y1;
			   int endx = slist1.get(i).x2;
			   int endy = slist1.get(i).y2;
			   paintLine( g2d, startx, starty, endx, endy, col); 
		   }*/
		//}
		
		
	}
	public void printStem(Stembg s) {
		Graphics2D g2d = (Graphics2D) g;
		System.out.println("Eneter 0");
		
			g.setColor(Color.BLUE);;;
			g.drawLine( s.x1, s.y1,s.x2,s.y2); 

			/*for(Stembg s :slist1) {
				//int x=(int)(s.* 30 +(Math.cos(s.getDirection()))*s.getlen()* 30);  //updated x coordinate of child stem
				//int y=(int)(s.getY()* 30+(Math.sin(s.getDirection()))*s.getlen()* 30);  //updated y coordinate of child stem
System.out.println(s.id);
				paintLine( g2d,s.x1, s.y1,s.x2,s.y2, Color.RED); 

				
			}*/
			
			

		
		
	}
	
	/*
	 * A local routine to ensure that the color value is in the 0 to 255 range.
	 */
	private int validColor(int colorVal) {
		if (colorVal > 255)
			colorVal = 255;
		if (colorVal < 0)
			colorVal = 0;
		return colorVal;
	}
	

	/**
	 * A convenience routine to set the color and draw a line
	 * @param g2d the 2D Graphics context
	 * @param startx the line start position on the x-Axis
	 * @param starty the line start position on the y-Axis
	 * @param endx the line end position on the x-Axis
	 * @param endy the line end position on the y-Axis
	 * @param color the line color
	 */
	private void paintLine(Graphics2D g2d, int startx, int starty, int endx, int endy, Color color) {
		g2d.setColor(color);
		
		for (int i=0;i<slist1.size();i++)
		{
		g2d.drawLine(slist1.get(i).x1, slist1.get(i).y1, slist1.get(i).x2, slist1.get(i).y2);
		}
	}
	
	void printstem(Stembg s){
		System.out.println("Print");
		paintLine(g,s.x1, s.y1, s.x2, s.y2,Color.BLACK);
		
		
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		System.out.println("Observer update method");
		
		if (arg instanceof BGGenerationSet) {
			bgg1 = (BGGenerationSet) arg;
			System.out.println("data rec size :"+bgg1.slist1.size());
		} 
		//slist1= (ArrayList<Stembg>) object;
		System.out.println("data is"+arg);
		this.revalidate();
		this.repaint();
	}

	
	
	
}
