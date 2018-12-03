/**
 * 
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

/**
 * @author krishnamodi
 * @NUID 001447420
 */
public class BGGenerationSet  extends Observable implements Runnable{

	
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
	int treeLevel=4; //Levels of the tree
	int option ;
	 int i=0;
	// Output format 
	
	public static String toString(Stembg stem) {
		return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",stem.id,stem.x2,stem.y2,stem.length);
	}
	// Growing tree 1
	
	 int k=0;

	public BGGenerationSet() {
		}
	public BGGenerationSet(int option,int levels) {
				
		this.option=option;
		this.treeLevel=levels;
		run();
	}
	  public void run() {
		  if(option==1) {
		  Pattern1 p1= new Pattern1(treeLevel);
		  System.out.println("etner3");
		  setChanged();
		  notifyObservers(slist1);
		  System.out.println("etner4 ");
		System.out.println("\n_____________________________________________________________________________________________________________\n\n");
		  }
		  else if(option==2) {
		  Pattern2 p2= new Pattern2(treeLevel);
		  setChanged();
		  notifyObservers(slist2);
	}
		  
	  }	  
	  /*
	   * 
	   * public static void main(String[] args) {
			BGGenerationSet bg= new BGGenerationSet();
			bg.run();
		}
*/
	
}
