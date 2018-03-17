import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Bob And GCD
Bob has an array 
A
A of size 
N
N. He doesn't like arrays in which the 
G
C
D
GCD of all elements is not 
K
K. He can perform multiple operations on an array. In each operation, he can either increase or decrease the value of an element by 
1
1. 
You have to tell the minimum operation Bob will take to make 
G
C
D
GCD of all elements in an array equal to 
K
K ?

GCD here is Greatest Common Divisor.

Input Format

The first line contains 
T
T, the number of test cases.

For Each Testcase : 
The first line contains 2 integers - 
K
K and 
N
N respectively, separated by a space.
The second line contains 
N
N integers, separated by a space, in order of their position in array.

Input Constraints

1
≤
T
≤
10
1≤T≤10 
 1
≤
N
≤
10
6
1≤N≤106 
 1
≤
A
[
i
]
≤
10
6
1≤A[i]≤106 
 1
≤
K
≤
10
6
1≤K≤106
Output Format

For each test case, print minimum number of operations Bob take in a new line.

Sample Input
1
5 3
4 5 6 
Sample Output
2

 * 
 * */






public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		List<Integer> gcdS = new ArrayList<Integer>();
		int testInputs[][] = new int[testCases][];
		for(int i=0;i<testCases;i++){
			int gcd = sc.nextInt();
			gcdS.add(Integer.valueOf(gcd));
			int size = sc.nextInt();
			int input[] = new int[size];
			for(int j=0;j<size;j++) {
				
				input[j] = sc.nextInt();
			}
			testInputs[i] = input;
			//System.out.println(gcdOperations(gcd, input));
		}
		
		for(int i=0;i<testCases;i++){
			System.out.println(gcdOperations(gcdS.get(i), testInputs[i]));
		}
		
	}
	public static int gcdOperations(int gcd,int[] input){
		int noOfElementsDivisible = 0;
		List<Integer> divisibleIndices = new ArrayList<Integer>();
		int pivotNumber = 0;
		List<Integer> pivotalNumbers = new ArrayList<Integer>();
		List<Integer> noOfOps = new ArrayList<Integer>();
		boolean isPivotSet = false;
		for(int i=0;i<input.length;i++){
			if(input[i]%gcd==0){
				noOfElementsDivisible++;
				//if(!isPivotSet){
					pivotNumber = input[i];
					pivotalNumbers.add(input[i]);
					isPivotSet = true;
				//}
				
				divisibleIndices.add(Integer.valueOf(i));
			}
		}
		int noOfOperations = 0;
		if(isPivotSet){
		for(int pivot:pivotalNumbers){
			
		for(int i=0;i<input.length;i++){
			pivotNumber = pivot;
			if(!divisibleIndices.contains(Integer.valueOf(i))){
				int temp = input[i];
				if(pivotNumber > temp){
					int reminder = pivotNumber%temp; 
					noOfOperations = noOfOperations + (reminder);
					temp = temp + (reminder);
					input[i] = temp;
					//noOfOps.add(noOfOperations);
					
				}
				else if(pivotNumber <  temp){
					int reminder = temp%pivotNumber;
					noOfOperations = noOfOperations + (reminder);
					temp = temp - (reminder);
					input[i] = temp;
					
					
				}
			}
		}
		noOfOps.add(noOfOperations);
		}
	}
		else {
			for(int i=0;i<input.length;i++){
				int temp = input[i];
				if(gcd > temp){
					noOfOperations = noOfOperations + (gcd-temp);
					temp =  temp + (gcd-temp);
					input[i] = temp;
					noOfOps.add(noOfOperations);
				}
				else if(gcd < temp){
					noOfOperations = noOfOperations + (temp - gcd);
					temp = temp - (temp-gcd);
					input[i] = temp;
					noOfOps.add(noOfOperations);
				}
			}
		}	
		int temp = noOfOps.get(0);
		for(int ops:noOfOps){
			if(ops < temp){
				temp = ops;
			}
		}
		return temp;
	}
}
