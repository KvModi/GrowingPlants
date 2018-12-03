/**
 * 
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author krishnamodi
 *
 */
public class Pattern1 extends BGGenerationSet implements Observable{
	public Pattern1(int maxN) {
		int angleDeviation=30; // angle deviation from the parent stem 
		int multiplier=5;// for the height ratio of tree
		
		slist1.clear();//add(0,stem);
		System.out.println("Tree 1 Details\n_______________\n");
		System.out.println("Id \tx2 \t y2 \t length \t angle \t \tx1 \t y1 \t parentid   level");
		stem=bg.growStem(stemid,stem.x2, stem.y2, 0, 90,-1,multiplier);
		slist1.add(stem);
		//System.out.println("Root :"+stem.toStringStem(stem)+" "+stem.x1+" "+stem.y1);
		//System.out.println("2 : "+stem.toStringStem(slist.get(0)));
		
		for(int level=1;level<maxN;level++) {
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
		
		//return slist1;
		
		//create new instance of class
		
	
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

}
