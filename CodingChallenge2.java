import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
phone numbers in US are written as (xxx) yyy-zzzz or xxx-yyy-zzzz
find the correct phone number from given ASCII string. find images for problem statements in this branch.
*/
public class CodingChallenge2 {
	
	static String extractDigits(String input, int noOfDigits){
		Pattern pattern = Pattern.compile("[0-9]+");
		
		String returnString= "";
		for(int i=0;i<input.length();i++){
			String charA = String.valueOf(input.charAt(i));
			Matcher matcher = pattern.matcher(charA);
			if(matcher.find()){
				returnString = returnString+charA;
			}
			
		}
		if(input.length()<noOfDigits){
			return "NONE";
		}
		else{
			return returnString.substring(0, noOfDigits);
		}
		
	}
	
	static String find_phone_number(String text) {
		String outputString = "";
		if(text.contains("-")){
			String[] tempArr = text.split("-");
			if(tempArr.length>3){
				return "NONE";
			}
			//for(int i=0;i<tempArr.length;i++){
				
			
				if(tempArr.length==2 ){
					
					String temp = tempArr[0];
					if(temp.startsWith("(")){
						String firstParts[] = temp.split("\\s+");
						if(firstParts.length!=2){
							return "NONE";
						}
						String first = firstParts[0];
						if(first.startsWith("(") && first.endsWith(")") && first.length()==5) {
							outputString= outputString+first;
						}
						String second = firstParts[1];
						if(second.length()==3){
							
							outputString=outputString+" "+second;
						}
					}
					
					String secondPart = tempArr[1];
					if(secondPart.length()<4){
						return "NONE";
					}
					secondPart= secondPart.substring(0, 4);
					outputString=outputString+"-"+secondPart;
				}
				
				else if(tempArr.length==3){
					
					String first = tempArr[0];
					String second = tempArr[1];
					String third = tempArr[2];
					if(first.length()<3){
						return "NONE";
					}
					first = extractDigits(first, 3);
					second = extractDigits(second, 3);
					third = extractDigits(third, 4);
					if(first.equals("NONE") || second.equals("NONE") || third.equals("NONE")) {
						return "NONE";
					}
					
				outputString=first+"-"+second+"-"+third;	
					
				}
			//}
		}
		else {
			return "NONE";
		}
		
		return outputString;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find_phone_number("xxx000-xxx999-78xx90111"));
	}

}
