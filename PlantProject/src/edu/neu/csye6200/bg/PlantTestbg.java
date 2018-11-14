/**
 * 
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Iterator;

import edu.neu.csye6200.sim.Stem2;

/**
 * @author krishnamodi
 * @NUID 001447420
 */
public class PlantTestbg {

	
	 int stemid;
	Stembg stem=new Stembg();
	Stembg child1=new Stembg();
	Stembg child2=new Stembg();
	
	static ArrayList<Stembg> slist=new ArrayList<>(1090);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		PlantTestbg pt=new PlantTestbg();
		pt.run();
		
	}
	static int i=0;
	private  void run() {
		createStemList();
	}

	public static String toString(Stembg stem) {
		return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",stem.id,stem.x2,stem.y2,stem.length);
	}
	
	public void createStemList(){

		slist.clear();//add(0,stem);
		System.out.println("id \tx2 \t y2 \t length \t angle \t \tx1 \t y1 \t parentid : level");
		stem=stem.growStem(stemid,stem.x2, stem.y2, 0, 90,0);
		slist.add(0,stem);
		//System.out.println("Root :"+stem.toStringStem(stem)+" "+stem.x1+" "+stem.y1);
		//System.out.println("2 : "+stem.toStringStem(slist.get(0)));
		
		for(int level=0;level<4;level++) {
			for(int n=0;n<Math.pow(2,level);i++,n++) {
				//System.out.println("i= "+i+"\t level= "+level);
				stem=slist.get(i);
				//System.out.println("Parent"+stem.toStringStem(stem));
			stemid++;
			child1=stem.growStem(stemid,stem.x2, stem.y2, level, stem.angle+25,i);
			slist.add(child1);
			stemid++;
			child2=stem.growStem(stemid,stem.x2, stem.y2, level, stem.angle-25,i);
			slist.add(child2);		
			
		}
			}
		

		Iterator<Stembg> iterator = slist.iterator();
		int j=0;
		while (iterator.hasNext()) {
			
		//	System.out.println(toStringStem(slist.get(i)));
		j++;
		}
		
	
	}

}
