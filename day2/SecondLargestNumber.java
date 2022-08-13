package week1.day2;

import java.util.Arrays;

public class SecondLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[22,67,98,1,34,58,99]
		int[] num = {22,67,98,1,34,58,99};
		int length = num.length;
		System.out.println(length);
		Arrays.sort(num);
        for (int i=0; i<=6; i++) {
        	System.out.println(num[i]);
        }
		System.out.println(num[length-2]);

	}

}
