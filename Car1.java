package week1.day2;

public class Car1 {

	public void printCarBrand() {
		System.out.println("Honda");
	}
	public String getCarColour() {
		return "white";
	}
	public int getCarEngineNumber() {
		return 1234647;

	}
	public int sumofTwoNum(int a, int b) {
		int c= a + b;
		return c;

	}
	public static void main(String[] args) {
		Car1 c = new Car1();
		c.printCarBrand();
		String carColour = c.getCarColour();
		System.out.println(carColour);
		int carEngineNumber = c.getCarEngineNumber();
		System.out.println(carEngineNumber);
		int sumofTwoNum = c.sumofTwoNum(3, 6);
		System.out.println(sumofTwoNum);

	}
}
