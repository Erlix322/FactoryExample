package CarPool;

public class FactoryCars {

	public Car getCar(String color){
		
		//Instanzieren der Klassen und Objektbildung
		if(color.equalsIgnoreCase("BLAU"))return new BlueCar();
		if(color.equalsIgnoreCase("GRÜN"))return new GreenCar();
		if(color.equalsIgnoreCase("ROT"))return new RedCar();		
		
		return null;		
		
	}
}
