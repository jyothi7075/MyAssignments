package week3.day1;

public interface Plan {
	//Will contains only blueprint
	//will contains abstract methods
	/**
	 * This method builds bedrooms with attached t&b and wardrobe storage
	 * @author Jyothi
	 * @param numbers-number of bedrooms that a house should have	 * 
	 */
	public void buildBedrooms(int number);
	public void buildBalcony();
	public void buildParking();
	
	//static final variables
	int totalSqft=1800;
	String name="Lake View";
	String[] flats= {"F1","F2"};
			
	

}
