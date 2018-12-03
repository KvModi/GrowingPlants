/**
 * 
 */
package edu.neu.csye6200.bg;

/**
 * @author krishnamodi
 * @NUID 001447420
 */
public class BGRule { // Biological Growth
	
	Stembg growStem(int id,int x1, int y1, int level, int angle, int parentid,int multiplier )
	{
		id++;
		Stembg s=new Stembg();
		s.id=id;
		s.x1=x1;
		s.y1=y1;
		s.level=level;
		s.parentid=parentid;
		/**
		 *  Calculating the end points from the the end points of parents
		 */
		s.x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * (10-level) *multiplier);
		s.y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) *(10-level) * multiplier);
		s.length=(int)Math.sqrt((s.y2-s.y1)*(s.y2-s.y1)+(s.x2-s.x1)*(s.x2-s.x1));// to find the length of each stem
		s.angle=angle;
		//System.out.println(toStringStem(s));
		return s;
		
	}

}
