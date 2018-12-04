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
public class BGGenerationSet extends Observable implements Runnable{

	
	 int stemid,stemid2;// id for each stem
	
	 BGRule bg;
	 Stembg stem;
	 int offset;
	Stembg child1=new Stembg();// since each stem gets divided into two, i have created 2 child variables
	Stembg child2=new Stembg();
	Stembg child3=new Stembg();
	// Array list to store the stem instances 
	 ArrayList<Stembg> slist1=new ArrayList<>(1090);
	static ArrayList<Stembg> slist2=new ArrayList<>(1090);
	static ArrayList<StemList> s=new ArrayList<>(1090);
	
	//static ArrayList<slist> childlist=new ArrayList<>(1090);
	int treeLevel=4; //Levels of the tree
	int option ;
	 int i=0,k=0;//  start id for tree 1 and tree 2
	 int angleDeviation=30; // angle deviation from the parent stem 
		int multiplier=5;// for the height ratio of tree
		
	// Output format 
	
	public static String toString(Stembg stem) {
		return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",stem.id,stem.x2,stem.y2,stem.length);
	}
	// Growing tree 1
	
	
	public BGGenerationSet() {
		}
	public BGGenerationSet(int option,int levels) {
		 stem=new Stembg(); // Parent Stem for tree 1
		bg=new BGRule();	
		this.option=option;
		this.treeLevel=levels;
		run();
		
	}
	@Override
	  public void run() {
		  setChanged();
		  notifyObservers("Data called #0");
		  
		int i=0;
		  if(option==1) {
			  slist1.clear();//add(0,stem);
				System.out.println("Tree 1 Details\n_______________\n");
				System.out.println("Id \tx2 \t y2 \t length \t angle \t \tx1 \t y1 \t parentid   level");
				stem=bg.growStem(stemid,stem.x2, stem.y2, 0, 90,0,multiplier);
				slist1.add(stem);
			  for(int level=1;level<treeLevel;level++) {
		 // patternOne(level);
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
		  
		 
		  setChanged();
		  notifyObservers(this);
		  System.out.println(">>>> Trying data calling");
			  }
			  Iterator<Stembg> iterator = slist1.iterator();
				int j=0;
				while (iterator.hasNext()) {
					
						System.out.println(stem.toStringStem(iterator.next()));
						
					
				
				}
		 System.out.println("\n_____________________________________________________________________________________________________________\n\n");
		 
		  }
		  else if(option==2) {
			  int k=0;
			  slist2.clear();//add(0,stem);
				System.out.println("Tree 2 Details\n_______________\n");
				System.out.println("id \tx2 \t y2 \t length \t angle \t \tx1 \t y1 \t parentid   level");
				stemid2++;
				stem=bg.growStem(stemid2,stem.x2, stem.y2, 0, 90,-2, multiplier);
				slist2.add(stem);
				  for(int level=1;level<treeLevel;level++) {
					  patternTwo(level);
					  angleDeviation=angleDeviation-3;
					  setChanged();
					  notifyObservers("Data called");
					  System.out.println("Trying data calling");
						  }
					 System.out.println("\n_____________________________________________________________________________________________________________\n\n");
					 
		  
	}
		  
	  }	  
	
	public  void patternOne(int level){
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
		
	}
	public  void patternTwo(int level){
		for(int n=0;n<Math.pow(2,level-1);n++) {
			stem=slist2.get(k); // get the parent to create a  child
			
			k++;
		stemid++;
		child1=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle+angleDeviation,k, multiplier);
		slist2.add(child1);
		stemid++;
		child2=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle,k, multiplier);
		slist2.add(child2);
		stemid++;
		child3=bg.growStem(stemid,stem.x2, stem.y2, level, stem.angle-angleDeviation,k, multiplier);
		slist2.add(child3);	
		
			
		}
		
	}
	  /*
	   * 
	   * public static void main(String[] args) {
			BGGenerationSet bg= new BGGenerationSet();
			bg.run();
		}
*/

		/*public ArrayList<Stembg> printfirst() {
			
			  Pattern1 p1= new Pattern1(3);
			  slist1=p1.Pattern1(treeLevel);
			  setChanged();
			  notifyObservers(slist1);
			  
			System.out.println("\n_____________________________________________________________________________________________________________\n\n");
			return slist1;}
			 */
}
