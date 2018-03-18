import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddEvenSubarrays {
/*
 * You are given an array A of N positive integer values. A subarray of this array is called Odd-Even subarray if the number of odd integers in this subarray is equal to the number  of even integers in this subarray.

Find the number of Odd-Even subarrays for the given array.

Input Format:
The input consists of two lines.

First line denotes N - size of array.
Second line contains N space separated positive integers denoting the elements of array A.

Output Format:
Print a single integer, denoting the number of Odd-Even subarrays for the given array.
 * SAMPLE INPUT 
4
1 2 1 2
SAMPLE OUTPUT 
4
 * 
 * */
	
	static void printSubArray(List<Integer> arrayList){
		
		for(int num:arrayList){
			System.out.print(num+" ");
		}
		System.out.println();
	}
	
	static int findOddEvenSubarray(int []array){
		int noOfSubArrays = 0;
		for(int i=0;i<array.length;i++) {
			List<Integer> intList = new ArrayList<Integer>();
			intList.add(array[i]);
			for(int j=i+1;j<array.length;j++){
				intList.add(array[j]);
				if(intList.size()%2==0) {
					boolean oddEvenEqual = false;
					int noOfOdds = 0,noOfEven = 0;
					for(int number:intList){
						if(number%2==0){
							noOfEven++;
						}
						if(number%2==1){
							noOfOdds++;
						}
					}
					if(noOfEven==noOfOdds){
						oddEvenEqual=true;
						noOfSubArrays++;
						//printSubArray(intList);
						
					}
				}
				
			}
			
		}
		
		return noOfSubArrays;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int inputArray[] = new int[arrSize];
		for(int i=0;i<arrSize;i++){
			
			inputArray[i] = sc.nextInt();
			
		}
		
		System.out.println(findOddEvenSubarray(inputArray));
		
	}

}
