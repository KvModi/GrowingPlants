/**
 * 
 */
package edu.neu.csye6200.bg;

import java.util.Iterator;

/**
 * @author krishnamodi
 *
 */
public class Pattern2 extends BGGenerationSet{
	BGCanvas canvas= BGCanvas.getInstance();
	public Pattern2(int treeLevel) {
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
		for(int level=1;level<treeLevel;level++) {
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
		
			//canvas.paiintl
			System.out.println(stem.toStringStem(iterator.next()));
		
		}
		
	}

}
