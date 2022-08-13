package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		Calculator c=new Calculator();
		int add = c.add(10, 5, 15);
		System.out.println("Addition of three numbers is: " + add);
		int sub = c.sub(10, 5);
		System.out.println("Subraction of two numbers is: " + sub);
		double mul = c.mul(100.56748, 500.485858);
		System.out.println("Multiplication of two numbers is: " + mul);
		float div = c.div(355.5667f, 575858.557f);
		System.out.println("division of two numbers is: " + div);

	}

}
