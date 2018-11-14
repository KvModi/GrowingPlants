package edu.neu.csye6200.sim;

import java.util.HashMap;


public class Stem {

	 static int stemid=0;
	int stemLength;
	static int startx;//[stemid][x-cor][y-cord]
	static int starty;
	static int endx;
	static int endy;
	static int level=0;
	int angle;
	private HashMap<Integer, Stem> childStem;
	
	Stem(){
		startx=0;
		starty=0;
		endx=0;
		endy=50;
		angle=-90;
		level=5;
	}
	public Stem( int nextid, int startx, int starty, int endx, int endy,int angle, int length) 
	{
		stemid=stemid+1;
		System.out.println("ff"+stemid);
		this.stemLength = length;
		this.startx = startx;
		this.starty = starty;
		this.endx=endx;
		this.endy=endy;
		childStem = new HashMap<Integer,Stem>();
		this.angle = angle;
			
		childStem=new HashMap<Integer,Stem>();
		growStem(startx, starty, angle, level);
		

	}
	public String formattedToString() {
		
		 return String.format("%-5d (%4d,%-4d)   %9d ",stemid,endx,endy,stemLength);
				 

		}
	/*private void growStem(int x2, int y2, int angle , int level) {// start pts. x, y, angle(direction),leve
		growStem( x2, y2, angle - 20, level - 1);

		growStem( x2, y2, angle + 20, level - 1);
	}*/
	public void growStem(int x1, int y1, int angle, int level) {
		if (level > 0) {
		System.out.println(stemid+"\t" +level+ "\t"+x1+"\t"+y1);
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * level * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * level * 10.0);
        
        stemid++;
        growStem( x2, y2, angle - 20, level - 1);
        growStem( x2, y2, angle + 20, level - 1);
		}
	}
	
}
