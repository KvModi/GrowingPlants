/**
 * 
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author krishnamodi
 * @NUID 001447420
 */
public class BGGenerationSet implements Runnable{

	
	 int stemid;// id for each stem
	Stembg stem=new Stembg(); // Parent Stem for tree 1
	//Stembg stem2=new Stembg();// Parent Stem for Tree 2
	BGRule bg=new BGRule();
	Stembg child1=new Stembg();// since each stem gets divided into two, i have created 2 child variables
	Stembg child2=new Stembg();
	Stembg child3=new Stembg();
	// Array list to store the stem instances 
	static ArrayList<Stembg> slist1=new ArrayList<>(1090);
	static ArrayList<Stembg> slist2=new ArrayList<>(1090);
	static ArrayList<StemList> s=new ArrayList<>(1090);
	
	//static ArrayList<slist> childlist=new ArrayList<>(1090);
	int n=4; //Levels of the tree
	
	static int i=0;
	// Output format 
	
	public static String toString(Stembg stem) {
		return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",stem.id,stem.x2,stem.y2,stem.length);
	}
	// Growing tree 1
	
	static int k=0;
	
	
	// Showing the biological growth

	/*public static void main(String[] args) {

		BGGenerationSet bggs=new BGGenerationSet();// Main method to print the output
		bggs.run();


	}*/
	  public void run() {
		  Pattern1 p1= new Pattern1();
		 /* slist1=p1.Pattern1();
		  System.out.println("\n\n BGGeneration\n\n");

			Iterator<Stembg> iterator = slist1.iterator();
			int j=0;
			while (iterator.hasNext()) {
				try {
					TimeUnit.SECONDS.sleep(01);
					System.out.println(stem.toStringStem(iterator.next()));
					// how to call the draw method over here ???????????????????
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			
		//sleep(300);
		System.out.println("\n_____________________________________________________________________________________________________________\n\n");
		Pattern2 p2= new Pattern2();
	}
	
}
