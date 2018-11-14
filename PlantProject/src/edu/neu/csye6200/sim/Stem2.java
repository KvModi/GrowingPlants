/**
 * @author krishna modi
 * nuid: 001447420
 *
 */
package edu.neu.csye6200.sim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Stem2 {
	private String base="src/";
	double thickness;
	int length;
	static int startx;//[stemid][x-cor][y-cord]
	static int starty;
	static int endx;
	static int endy;
//	public static HashMap<Integer, Integer> childStem = new HashMap<Integer,Integer>(); // parent id number of children
	public static HashMap<Integer,ChildStem> child = new HashMap<>();
	ArrayList<Stem2> childrenList;
	static int counter=0;
	static int stemid=0;
	int id;
	int children;
	static int level=0;
	int angle;
	static int len;


	Stem2(){
		
	}
	public Stem2( int length, int startx, int starty, int endx, int endy,double angle) 
	{
		this.length = length;
		this.startx = startx;
		this.starty = starty;
		children=0;
		
		this.angle = (int) angle;
		id=stemid++;
		
		

	}
public Stem2(int id,int lenStem, int x1, int y1) {
	this.stemid=id;
	this.length = lenStem;
	this.startx = x1;
	this.starty = y1;
	}
int i=0;
	public void growStem(int x1, int y1, double angle, int level) {
		
		
		
		try {  //open source and destination files
			//FileReader reader=new FileReader(base+"tp.txt");
			FileWriter writer;
			if(stemid==0)
				{
				 writer=new FileWriter(base+"stemData.txt");
				 writer.write("ID\t Start points\t End Points\n");
				}
			else {
				
			 writer=new FileWriter(base+"stemData.txt",true);
			 }
			
			if (level != 0) {

				int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * level * 10.0);
				endx=x2;
				startx=x1;
				int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * level * 10.0);
				
				endy=y2;	
				starty=y1;
				// to find the length of the tree
				int lenStem=(int)Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
				//static Stem2 s= new Stem2(lenStem, x1, y1, x2, y2, angle);
				childrenList.add(new Stem2(counter,x1,y1,x2,y2,angle));
				child.put(counter,new ChildStem(stemid,x1,y1,lenStem));
				counter++;
				System.out.println(stemid+"\t("+x2+","+y2+") \t"+lenStem+"\t ("+x1+","+y1+")");
				//System.out.println(stemid+"\t("+x2+","+y2+") \t"+lenStem);
				//child.put(0, new Stem2(lenStem,x1,y1));
				if (len<y2)//to find the length of the tree
					len=y2;
				//childStem = new HashMap<Integer,Stem>();
				writer.write(stemid+" ");
				writer.write("("+startx+","+starty+") ");
				writer.write("("+endx+","+endy+") ");

				writer.write("\n");


				//responsibility to close open files
				//reader.close();
			stemid++;
				growStem( x2, y2, angle - 20, level - 1);

				growStem( x2, y2, angle + 20, level - 1);
				//1childStem.put(id, s );
				
				writer.close();
				
			}
		}catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}catch (IOException e) {

				e.printStackTrace();
			}
	 
			
	
		

	}
	public int findH() {

		return len;
	}
	public void deleteStem(int id) {




	}

	public void getChildren() {
	//	System.out.println(child.entrySet().toString());//get(1));
	
		for(i=0;i<child.size();i++) {
		ChildStem s=child.get(i);
		System.out.println(s.toString(s));
	}
	}
	
	
	public void addStem(Stem2 s) {

		if(s.startx==this.endx & s.starty==this.endy)
		{
			this.children=this.children+1;
		}
		//child.put(s.getId(), s);
		
			for(i=0;i<child.size();i++)
		System.out.println(child.get(i));


	}
	/*
	public int getChildren() {
		System.out.println("Details of Stem : "+this.getId());
		System.out.println("Number of children :"+getChildren());
		if(getChildren()>0) {
			System.out.println("StemId/t X/t Y/t Angle /t Children");
			for(int key:childStem.keySet())
			{
				System.out.println(childStem.get(key));
			}
			System.out.println("\n");
		}
		return children;
	}

*/
	public double getThickness() {
		return thickness;
	}

	public int getLength() {
		return length;
	}

	public int getStartx() {
		return startx;
	}

	public int getStarty() {
		return starty;
	}

	public int getEndx() {
		return endx;
	}

	public int getEndy() {
		return endy;
	}


	public static int getStemid() {
		return stemid;
	}

	public int getId() {
		return id;
	}



	public static int getLevel() {
		return level;
	}

	public int getAngle() {
		return angle;
	}


	public String toString() {
		return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",getId(),getStartx(),getStarty(),getLength());
	}
	public String toString(Stem2 s) {
		return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",getId(),getStartx(),getStarty(),getLength());
	}



}



