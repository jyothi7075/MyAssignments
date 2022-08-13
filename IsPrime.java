package week1.day2;

public class IsPrime {

	public static void main(String[] args) {
		int n=44;
		for(int i=2;i<=n-1;) {
			if(n%i==0) {
				System.out.println("non-prime");
				break;
			}
			else {
				System.out.println("prime");
				break;
			}
		}

	}

}
