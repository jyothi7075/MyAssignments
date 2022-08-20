package week1.day1;

public class ConvertANegativeNumberToAPositiveNumber {
	public static void main(String[] args) {
		int num=-40;
		if(num<0) {
			System.out.println("The number is negative");
		}
		num=num+41;
		System.out.println(num);
		if (num>0) {
			System.out.println("The number is positive");
		}

	}
}
