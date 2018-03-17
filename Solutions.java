import java.util.Scanner;

public class Solutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int input[] = new int[size];
		for(int i=0;i<size;i++){
			input[i] = sc.nextInt();
		}
		for(int i=0;i<input.length;i++){

			String temp1 = fX(i,input[i], input);
			if(temp1.equals("-1")){
				System.out.print("-1 ");
			}
			else{
			int temp2 = gX(Integer.valueOf(temp1.split(":")[0]),Integer.valueOf(temp1.split(":")[1]), input);
			System.out.print(temp2+" ");
			}
		}
	}
	
	public static String fX(int index,int number, int []input){
		int temp = -1;
		
		for(int i=0;i<input.length;i++){
			try{
			if(index < i && i < input.length && number < input[i]){
			
				temp = i;
				break;
		
			}
			}catch(Exception e){
				temp = -1;
			}
		}
			if(temp== -1){
				return "-1";
			}	
		return temp+":"+input[temp];
	}
	
	public static int gX(int index,int number, int[] input){
		int temp = -1;
		if(index == -1){
			return -1;
		}
		for(int i=0;i<input.length;i++){
			try{
			if(index < i && i < input.length && number > input[i]){
				
					temp = i;
					break;
				
			}
			} catch(Exception e){
				temp = -1;
			}
		}
		
		
		return input[temp];
	}

}
