import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodingChallenge1 {

	public static String solution(int[] array){

		String outputString = "";
		List<String> outputList = new ArrayList<String>();
		for(int i=0;i<array.length;i++){
			
			int iTemp = array[i];
			
			if(iTemp!=-999999999){
			int currentDifference = 0;
			for(int j=i+1;j<array.length;j++){
				
				int jTemp = array[j];
				int temp = iTemp;
				if(iTemp!=-999999999 && jTemp!=-999999999){
					int tempIndex = j;
					int noOfIntegers = 1;
					int tempDifference=1;
					while(tempDifference==1 && tempIndex<array.length){
						 tempDifference = jTemp-temp;
						currentDifference = jTemp-iTemp;
						noOfIntegers++;
						
						if(tempDifference==1){
							tempIndex = tempIndex+1;
							if(tempIndex<array.length){
								
								temp = jTemp;
								//iTemp = jTemp;
								jTemp = array[tempIndex];
								
							}
							
							
						}
						
					}
					if(tempDifference!=1){
						jTemp = array[tempIndex-1];
						tempIndex = tempIndex-1;
					}
					if(noOfIntegers>=3){
						
						outputList.add(iTemp+"-"+jTemp);
						//outputString=outputString+iTemp+"-"+jTemp+",";
						if(tempIndex==array.length){
							tempIndex = tempIndex-1;
									
						}
						for(int k=tempIndex;k>=i;k--){
							array[k]= -999999999;
						}
						iTemp = -999999999;
						jTemp = -999999999;
					}
					/*if(currentDifference>2){
						outputString=outputString+iTemp+",";
						array[i] = -999999999;
						iTemp = -999999999;
					}*/
					else{
						outputList.add(String.valueOf(iTemp));
						//outputString=outputString+","+iTemp;
						array[i] = -999999999;
						iTemp = -999999999;
						
					}
					
					if(iTemp==-999999999){
						break;
					}
					if(tempIndex==array.length){
						
						for(int a=i;a<tempIndex;a++){
							outputList.add(String.valueOf(array[a]));
							//outputString=outputString+","+array[a];
							array[a] = -999999999;
						}
					}
				}
			}
		}
			if(i==array.length-1){
				
				if(iTemp!=-999999999) {
					outputList.add(String.valueOf(iTemp));
					
				}
				
			}
			
			
		}
		for(int i=0;i<outputList.size();i++){
			outputString= outputString+","+outputList.get(i);
		}
		if(outputString.startsWith(",")){
			outputString = outputString.replaceFirst(",", "");
		}
		if(outputString.endsWith(",")){
			outputString = outputString.substring(0, outputString.length()-1)
;		}
		return outputString;
	}
	
	 public static void main(String[] args) throws IOException {
	        Scanner in = new Scanner(System.in);
	        int arraySize = in.nextInt();
	        int array[] = new int[arraySize];
	        for(int i=0;i<arraySize;i++){
	        	array[i] = in.nextInt();
	        }
	        
	        System.out.println(solution(array));
	       
	    }
}
