package edu.neu.csye6200.sim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlantTest {

	HashMap<Integer, Plant> plants = new HashMap<>(); 
	ArrayList<Plant> plantArrayList=new ArrayList<>();
	RegistryIO io=new RegistryIO();
	public PlantTest() {

	}

	public static void main(String[] args) {
		PlantTest pt=new PlantTest();

		{
			pt.run();
		}
	}

	void run() {
		PlantRoster pr= PlantRoster.instance();
		plantEntry();

		stemEntry();              
		flowerEntry();
		pr.sort(plantArrayList);



	}
	private void plantEntry() {

		System.out.println("Plant Details:\n");
		System.out.println("Id   Type \t Age(years)  Height");
		System.out.println("____________________________________");
		//String plantType, double plantAge, int stemType, double growthRate
		Plant p1=new Plant("Shrub",0.6, 1,1.5);
		Plant p2=new Plant("Succulents",10.0, 2,0.25);
		Plant p3=new Plant("Trees",20.3, 3,2);
		Plant p4=new Plant("Vines",2.0, 4,2.5);
		Plant p5=new Plant("Grass",0.3, 5,0.05) ;
		// plant arrayList added for sorting data in Roster
		plantArrayList.add(p5);
		plantArrayList.add(p1);
		plantArrayList.add(p3);
		plants.put(2,p2);
		plantArrayList.add(p2);
		plants.put(3,p3);
		
		plants.put(4,p4);
		plantArrayList.add(p4);
		plants.put(5,p5);
		plants.put(1,p1);

		for (int i=1;i<6;i++) { // to disply the hasp map of plants
			System.out.println(formattedToString(plants.get(i)));
		}
		io.save(plants, "PlantData");
		System.out.println("Read the data");
		io.load( "PlantData");


	}
	private void flowerEntry() {
		HashMap<Integer, FlowerPlant> flowers = new HashMap<>(); 
		System.out.println("\n\nFlower Details:\n");
		System.out.println("Id TreeType Color  No.of Petals");
		System.out.println("____________________________________");
		FlowerPlant f1=new FlowerPlant("Red",3,plants.get(1),1);
		flowers.put(1,	f1);
		FlowerPlant f2=new FlowerPlant("Pink",13,plants.get(4),2);
		flowers.put(2,f2);

		System.out.println(f1.formattedToString());
		System.out.println(f2.formattedToString());
		f2.grow("Brown");

		System.out.println(f2.formattedToString());
	}
	private void stemEntry() {
		HashMap<Integer, Stem2>  stems=new HashMap<>();
		// int length, int startx, int starty, int endx, int endy,int angle, int nextid
		Stem2 s1=new Stem2(12,0,0,20,30,90);
		stems.put(1,s1 );
		System.out.println();
		System.out.println("\n\nStemData\n__________");
		System.out.println("Id   EndPoint(x,y)   Length	StartPoint(x,y)");
		s1.growStem(0, 0, 90, 5);// x,y, angle, levels
		//s1.addStem(s1);
		System.out.println("Stem Children\n__________");
		System.out.println("Id   ParentPoint(x,y)   Length	");
		s1.getChildren();
		/*	
		 for (int i=1;i<=stems.size();i++) { 
			 System.out.println(formattedToString(stems.get(i)));	 
				7

		 }*/
	}

	public String formattedToString(Plant p) {

		return String.format("%-5d %-10s %3$9.2f %4$8.2f",p.plantId,p.plantType,p.plantAge,p.plantHeight);


	}
	public String formattedToString(Stem2 s) {

		return String.format("%-5d (%4d,%-4d)   %9d ",s.stemid,s.endx,s.endy,s.getLength());


	}
}
