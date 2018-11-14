package edu.neu.csye6200.sim;
/**
 * NUID : 001447420
 * @author krishnamodi
 *
 */
public class Plant {
	 int  plantId=0;
	String plantType;
	double plantAge, plantHeight, plantWidth;
	int stemType;
	double growthRate;
	double timePassed=10;

	
	Plant(String plantType, double plantAge, int plantId, double growthRate) {
		this.plantId = plantId;
		this.plantType = plantType;
		this.plantAge = plantAge+timePassed; // when i want time from the user, i can add an argument and put the value in timePassed
		//this.stemType = plantId;
		this.growthRate = growthRate;
		this.plantHeight=grow(this.growthRate, this.plantAge);
	}


	public double grow(double growth,double age) {
		return (growth*age);
	}

public String formattedToString() {
		
		String st=String.format("%-10s %2$4d %3$9.2f %4$5.2f",plantType,plantId,plantAge,plantHeight);
		return st; 

	}
	

}