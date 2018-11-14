
public class Plant {
	static int  plantId=0;
	String plantType;
	double plantAge, plantHeight, plantWidth;
	int stemType;
	double growthRate;
	

	
	Plant(String plantType, double plantAge, int stemType, double growthRate) {
		this.plantId = plantId++;
		this.plantType = plantType;
		this.plantAge = plantAge;
		this.stemType = stemType;
		this.growthRate = growthRate;
	}


	Plant(){
		plantId=0;
		String plantType[]= {"","Shrub","Succulents","Trees","Vines", "Grass"};
		System.out.println("Types of Plants:- \nId - Type");
		/* cannot use for each as it does not keep track of the index
		for(String pt : plantType) {
			
			System.out.println(pt.indexOf(pt)+pt);
		}*/
	
		for(int i=0;i<(plantType.length);i++) {
			System.out.println(" "+(i+1)+" - "+plantType[i]);
		}
		
		
		
	}


	public static void main(String[] args) {
			Plant pt=new Plant();
			
			
	
		}
	

}
