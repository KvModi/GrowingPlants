package edu.neu.csye6200.sim;

import java.util.HashMap;

public class FlowerPlant {
	String color;
	int petals;
	Plant plants;
	 int flowerid=0;
	public FlowerPlant(String color,int petals, Plant plants,int id)  // FlowerPlant constructor
	{
		      
		this.color=color;
		this.petals=petals;
		this.plants=plants;
		this.flowerid=id;
		
	}
	public void grow(String color) {
	
		if(petals>10)
		{
			petals=0;
			this.color="Black";
		}
			else
			
		{
			petals=petals+5;
		this.color=color;
		
		}
		this.flowerid=this.flowerid+1; 
		
	}
	 public String formattedToString() {
			
		 return String.format("%-3d %-8s %-8s %9d  ",flowerid,plants.plantType,color,petals);
				 

		}

}
