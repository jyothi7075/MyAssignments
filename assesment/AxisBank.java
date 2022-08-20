package week3.assesment;

public class AxisBank extends BankInfo {
	public int deposit() {
		//System.out.println("Deposit amount is 6 lakhs");
		return 7000000;
	}
	public static void main(String[] args) {
		AxisBank AB=new AxisBank();
		System.out.println(AB.deposit());
	}
}
