package week3.day1;

public class Myhouse {

	public static void main(String[] args) {
		// scope restrictions- Restricting visibility of object only to the interface
		Plan land= new Land();
		land.buildBedrooms(5);
		land.buildBalcony();
		land.buildParking();
		//as we use a method which is not declared in interface class 
		//if we want to use this create an object Land land=new Land();
		//land.buildGarden();

	}

}
