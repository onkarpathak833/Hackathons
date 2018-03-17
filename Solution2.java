import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int []input = new int[size];
		for(int i=0;i<size;i++){
			input[i] = sc.nextInt();
		}
		List<Integer> primeList = new ArrayList<Integer>();
		List<Integer> nonPrime = new ArrayList<Integer>();
		List<Integer> ones = new ArrayList<Integer>();
		List<Integer> allList = new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			if(isPrime(input[i])){
				primeList.add(Integer.valueOf(input[i]));
			}
			else if(input[i]==1){
				ones.add(Integer.valueOf(1));
			
			}
			else {
				nonPrime.add(Integer.valueOf(input[i]));
			}
		}
		int temp = 0;
		Collections.sort(primeList);
		Collections.sort(nonPrime,Collections.reverseOrder());
		
		int finalSize = primeList.size()+nonPrime.size()+ones.size();
		int j=0;
		while(j<primeList.size() && primeList.size() > 0){
			allList.add(primeList.get(j));
			j++;
		}
		j=0;
		while(j<nonPrime.size() && nonPrime.size() > 0){
			allList.add(nonPrime.get(j));
			j++;
		}
		j=0;
		while(j<ones.size() && ones.size()>  0){
			allList.add(ones.get(j));
			j++;
		}
		for(int i=0;i<allList.size();i++){
			System.out.print(allList.get(i)+" ");
		}
	}
	
	public static boolean isPrime(int num){
	    if ( num > 2 && num%2 == 0 ) {
	        //System.out.println(num + " is not prime");
	        return false;
	    }
	    if(num == 1){
	    	return false;
	    }
	    int top = (int)Math.sqrt(num) + 1;
	    for(int i = 3; i < top; i+=2){
	        if(num % i == 0){
	            //System.out.println(num + " is not prime");
	            return false;
	        }
	    }
	    //System.out.println(num + " is prime");
	    return true; 
	}
	

}
