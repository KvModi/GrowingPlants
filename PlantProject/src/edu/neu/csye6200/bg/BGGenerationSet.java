/**
 * 
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author krishnamodi
 * @NUID 001447420
 */
public class BGGenerationSet {

	
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
	int n=5; //Levels of the tree
	
	static int i=0;
	// Output format 
	
	public static String toString(Stembg stem) {
		return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",stem.id,stem.x2,stem.y2,stem.length);
	}
	// Growing tree 1
	public void createStem1List(){
		int angleDeviation=30; // angle deviation from the parent stem 
		int multiplier=5;// for the height ratio of tree
		
		slist1.clear();//add(0,stem);
		System.out.println("Tree 1 Details\n_______________\n");
		System.out.println("Id \tx2 \t y2 \t length \t angle \t \tx1 \t y1 \t parentid   level");
		stem=bg.growStem(stemid,stem.x2, stem.y2, 0, 90,-1,multiplier);
		slist1.add(stem);
		//System.out.println("Root :"+stem.toStringStem(stem)+" "+stem.x1+" "+stem.y1);
		//System.out.println("2 : "+stem.toStringStem(slist.get(0)));
		
		for(int level=1;level<n;level++) {
			for(int n=0;n<Math.pow(2,level-1);n++) {
			stem=slist1.get(i); // get the parent to create a  child
				i++;//to get the parent id // to get all ids to create their child stems
			stemid++;// each stem gets a new id
			child1=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle+angleDeviation,i, multiplier); // First stem
			slist1.add(child1);
			stemid++;
			child2=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle-angleDeviation,i, multiplier);//second stem
			slist1.add(child2);		
			
		}
			angleDeviation=angleDeviation-3;
			
			}
		

		Iterator<Stembg> iterator = slist1.iterator();
		int j=0;
		while (iterator.hasNext()) {
			
			System.out.println(stem.toStringStem(iterator.next()));
		
		}
		
		
		
	
	}	
	
	static int k=0;
	
	public void createStem2List(){
		int angleDeviation=25; // angle deviation from the parent stem 
		int offset=slist1.size(); // the id will start after the previous plant's id
		int multiplier=10;// for the height ratio of tree
		slist2.clear();//add(0,stem);
		System.out.println("Tree 2 Details\n_______________\n");
		
		System.out.println("id \tx2 \t y2 \t length \t angle \t \tx1 \t y1 \t parentid   level");
		stemid++;
		stem=bg.growStem(stemid,stem.x2, stem.y2, 0, 90,-2, multiplier);
		slist2.add(stem);
		//System.out.println("Root :"+stem.toStringStem(stem)+" "+stem.x1+" "+stem.y1);
		//System.out.println("2 : "+stem.toStringStem(slist.get(0)));
		// for loop to grow stems
		for(int level=1;level<n;level++) {
			for(int n=0;n<Math.pow(3,level-1);n++) {
				
				stem=slist2.get(k); // get the parent to create a  child
				
				k++;
			stemid++;
			child1=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle+angleDeviation,offset+k, multiplier);
			slist2.add(child1);
			stemid++;
			child2=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle,offset+k, multiplier);
			slist2.add(child2);
			stemid++;
			child3=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle-angleDeviation,offset+k, multiplier);
			slist2.add(child3);	
			
		}
			
			}
		

		Iterator<Stembg> iterator = slist2.iterator();
		
		while (iterator.hasNext()) {
			
			System.out.println(stem.toStringStem(iterator.next()));
		
		}
		
		
	
	}
	// Showing the biological growth

	public static void main(String[] args) {

		BGGenerationSet bggs=new BGGenerationSet();// Main method to print the output
		bggs.run();


	}
	private  void run() {
		createStem1List();
		System.out.println("\n_____________________________________________________________________________________________________________\n\n");
		createStem2List();
	}
	
}
