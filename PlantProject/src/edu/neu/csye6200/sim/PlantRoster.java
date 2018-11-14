package edu.neu.csye6200.sim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class PlantRoster {

	// singleton class
	private static Logger log = Logger.getLogger(PlantRoster.class.getName());
	private static PlantRoster instance=null;
	private  ArrayList<Plant> plantList = new ArrayList<>();
	private HashMap<Integer,Plant>plants = new HashMap<Integer,Plant>();
	private PlantRoster() {
		
	}
	
	public static PlantRoster instance() {
		if(instance==null)
			instance = new PlantRoster();
		return(instance);
	}
	public  void display(String args[]) {
		for (Plant plant:plantList ) {
			String fTxt= String.format("Plant : %1$8s %2$8d", plant.plantType,plant.plantId);
			System.out.println(fTxt);
		}
	}
	
	public void sort(ArrayList<Plant> plantArrayList)
	{
		
		int id[] = new int[5];
		int i=0;
		System.out.println("\n\nBefore Sorting Plant List \n");
		for(Plant p:plantArrayList)
		{
				id[i]=p.plantId;
				plants.put(id[i], p);
				i++;	
				System.out.println(formattedToString(p));	
		}
		
		
		System.out.println("\n\nAfter Sorting Plant List\n");
		
		quicksort(id,0,id.length-1);
		
		for(int j=0;j<id.length;j++)
		{
			//System.out.print(" " + id[j]);
			System.out.println(formattedToString(plants.get(id[j])));
		}
		System.out.println();
	}
	private void quicksort(int data[],int left, int right)
	{
		int i,j;
		int x,y;
		i=left;
		j=right;
		x = data[(left+right)/2];
		
		do
		{
			while((data[i]<x)&& (i<right)) i++;
			while((x<data[j]&&(j> left))) j--;
			
			if(i<=j)
			{
				y=data[i];
				data[i]=data[j];
				data[j]=y;
				i++;
				j--;
			}
		}while(i<=j);
		if(left<j)
		{
			quicksort(data,left,j);
		}
		if(i<right)
		{
			quicksort(data,i,right);
		}
		
	}
	public String formattedToString(Plant p) {

		return String.format("%-5d %-10s %3$9.2f %4$8.2f",p.plantId,p.plantType,p.plantAge,p.plantHeight);


	}
}
