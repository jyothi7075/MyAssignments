package week1.day2;

import java.util.Arrays;

public class MissingElementInArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		int length = arr.length;
		System.out.println(length);
		for(int i=0; i<7; i++) {
			if(arr[4]==i+1) {

				System.out.println("Missing Element in arry is: " +i); 	

			}
		}


	}
}


