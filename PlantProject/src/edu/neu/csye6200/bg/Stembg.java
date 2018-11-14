/**
 * 
 */
package edu.neu.csye6200.bg;

/**
 * @author krishnamodi
 * @NUID 001447420
 */

public class Stembg {

	static int id=0;
	int x1,y1,x2,y2; //start (x1,y1) and end (x2,y2) points of the stem
	int length;// length of each stem
	int angle;
	int parentid;
	int level;
	
	
	public  Stembg() {
		id=0;
		x1=0;
		y1=0;
		angle=90;
		id=-1;
		x2=0*(int) (Math.cos(Math.toRadians(angle)) * (20-level) * 10.0);
		y2=0*(int) (Math.sin(Math.toRadians(angle)) *(20-level) * 10.0);
		length=(int)Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
		
	}
	Stembg growStem(int id,int x1, int y1, int level, int angle, int parentid )
	{
		id++;
		Stembg s=new Stembg();
		s.id=id;
		s.x1=x1;
		s.y1=y1;
		s.level=level;
		s.parentid=parentid;
		s.x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * (10-level) * 10.0);
		s.y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) *(10-level) * 10.0);
		s.length=(int)Math.sqrt((s.y2-s.y1)*(s.y2-s.y1)+(s.x2-s.x1)*(s.x2-s.x1));// to find the length of each stem
		s.angle=angle;
		System.out.println(toStringStem(s));
		return s;
		
	}
	public static String toStringStem(Stembg stem) {
		return String.format("%-5d \t %4d \t %-4d \t %9d \t %9d \t %-4d \t %-4d \t %-4d \t %-4d",stem.id,stem.x2,stem.y2,stem.length,stem.angle,stem.x1,stem.y1,stem.parentid,stem.level);
	}

}
