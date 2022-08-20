package week3.day1;

public class AxisBank extends InfoBank {
	public int deposit() {
		//System.out.println("Deposit amount is 6 lakhs");
		return 7000000;
	}
	public static void main(String[] args) {
		AxisBank AB=new AxisBank();
		System.out.println(AB.deposit());
	}
}
