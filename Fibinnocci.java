package week1.day2;

public class Fibinnocci {

	public static void main(String[] args) {
		int firstNum=0;
		int secNum=1;
		System.out.println(firstNum+"\n"+secNum);
		int sum;
		for(int i=0;i<9;i++) {
			sum=firstNum+secNum;
			firstNum=secNum;
			secNum=sum;
			System.out.println(""+sum);
		}
			

	}

}
