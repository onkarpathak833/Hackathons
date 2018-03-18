import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * You are given a grid A of size , two integers () and Q tasks. Each task contains two integers, (). Each cell in the grid is either empty cells denoted by O (Capital English character 'o') or occupied cells denoted by . Initially, you are at (). Find the minimum number of steps in which you have to take to reach () from () without traversing the occupied cells.

In a single step, you can move from any cell (i,j) to the 4 neighboring cells i.e. (,j), (,j), (i,) and (i,) provided these cells are inside the grid A.

Input Foramt
The first line of input contains 3 space separated integers N, M and Q where N and M denotes the dimensions of the grid A and Q denotes the number of tasks.
Each of the next N lines contain a string of length M,  character in the  line of which is either O or denoting that the cell () is empty or occupied.
The next line contains 2 space separated integers  and  denoting the source cell of the grid.
This is followed by Q lines each containing 2 space separated integers  and .

Output Format
Print the answer to each query on a new line. If there is no path between () and () , print .
 * 
 * */
public class GridSolution {

	public static int noRows = 0;
	public static int noColumns = 0;
	public static int initialI = 0;
	public static int initialJ = 0;
	public static int noOfSteps=99999;
	public static List<String> travelledVertices = new ArrayList<String>();
	static boolean ifEqualVertices(int startI,int startJ,int endI,int endJ){
		if(startI==endI && startJ==endJ){
			return true;
		}
		
		return false;
	}
	
	static boolean ifAdjacentVertices(int startI,int startJ,int endI,int endJ){
		
		if(startI+1<noColumns){
			int possibleI = startI+1;
			if(possibleI==endI && startJ==endJ){
				return true;
			}
			
		}
		if(startI-1>=0){
			int possibleI = startI-1;
			if(possibleI==endI && startJ==endJ){
				return true;
			}
			
		}
		if(startJ+1<noRows){
			int possibleJ = startJ+1;
			if(startI==endI && possibleJ==endJ){
				return true;
			}
		}
		
		if(startJ-1>=0){
			
			int possibleJ = startJ-1;
			if(startI==endI && possibleJ==endJ){
				return true;
				
			}
		}
		
		return false;
	}
	
	static int findSteps(char[][] matrix,int startI,int startJ, int endI,int endJ, int currentNoOfSteps){
		int distanceI = 0,distanceJ = 0;
		distanceI = endI-startI;
		distanceJ = endJ - startJ;
		List<String> verticesList = findAdjacentEmptyVertices(matrix, startI, startJ);
		int tempDist = 99999;
		List<String> tempList = new ArrayList<String>();
		for(int i=0;i<verticesList.size();i++){
			
			String vertex = verticesList.get(i);
			int iVertex = Integer.valueOf(vertex.split(",")[0]);
			int jVertex = Integer.valueOf(vertex.split(",")[1]);
			int currentDist = (int) Math.pow((endI-iVertex), 2) + (int)Math.pow((endJ-jVertex),2);
			if(currentDist < tempDist){
				tempDist = currentDist;
				if(tempList.isEmpty()){
					tempList.add(iVertex+","+jVertex);
				}
				else if(!tempList.isEmpty()){
					tempList.clear();
					tempList.add(iVertex+","+jVertex);
				}
			}
			else if(currentDist==tempDist){
				tempList.add(iVertex+","+jVertex);
			}
		}
		for(int i=0;i<tempList.size();i++) {
			String vertices = tempList.get(i);
			int iVertex = Integer.valueOf(vertices.split(",")[0]);
			int jVertex = Integer.valueOf(vertices.split(",")[1]);
			int tempSteps = 0;
			currentNoOfSteps++;
			/*if(iVertex==endI && jVertex==endJ){
				tempSteps++;
				if(tempSteps<noOfSteps){
					noOfSteps=tempSteps;
				}
				return noOfSteps;
			}*/
		if(!travelledVertices.contains(iVertex+","+jVertex)){
			travelledVertices.add(iVertex+","+jVertex);
			if(ifAdjacentVertices(iVertex, jVertex, endI, endJ)){
				currentNoOfSteps++;
				if(currentNoOfSteps<noOfSteps){
					noOfSteps=currentNoOfSteps;
				}
				return noOfSteps;
			}
			else if(ifEqualVertices(iVertex, jVertex, endI, endJ)){
				noOfSteps = currentNoOfSteps;
				return noOfSteps;
			}
			else{
				
				 currentNoOfSteps = findSteps(matrix, iVertex, jVertex, endI, endJ,currentNoOfSteps);
				 if(currentNoOfSteps<noOfSteps){
					 noOfSteps = currentNoOfSteps;
					 
				 }
				 return noOfSteps;
				//return steps;
				/*while(!ifAdjacentVertices(iVertex, jVertex, endI, endJ)){
					List<String> verticesListTemp = findAdjacentEmptyVertices(matrix, iVertex, jVertex);
					tempSteps++;
					if(tempSteps<noOfSteps){
						noOfSteps=tempSteps;
					}
				}
				return noOfSteps;
			}*/
			
		}
		}
		else{
			currentNoOfSteps = currentNoOfSteps-1;
			noOfSteps = noOfSteps-1;
		}
		
	}
		return -1;	
	}
	
	
	static List<String> findAdjacentEmptyVertices(char[][]matrix,int startI,int startJ){
		List<String> emptyVertices = new ArrayList<String>();
		if(startI+1<noColumns){
			int possibleI = startI+1;
			if(matrix[possibleI][startJ]!='*' && possibleI!=initialI){
				emptyVertices.add(possibleI+","+startJ);
			}
			
		}
		if(startI-1>=0){
			int possibleI = startI-1;
			if(matrix[possibleI][startJ]!='*' && possibleI!=initialI){
				emptyVertices.add(possibleI+","+startJ);	
			}
			
		}
		if(startJ+1<noRows){
			int possibleJ = startJ+1;
			if(matrix[startI][possibleJ]!='*' && possibleJ!=initialJ){
				emptyVertices.add(startI+","+possibleJ);
			}
		}
		
		if(startJ-1>=0){
			
			int possibleJ = startJ-1;
			if(matrix[startI][possibleJ]!='*' && possibleJ!=initialJ){
				emptyVertices.add(startI+","+possibleJ);
				
			}
		}
		return emptyVertices;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int rowCount = sc.nextInt();
		int columnCount = sc.nextInt();
		int noTasks = sc.nextInt();
		noRows = rowCount;
		noColumns = columnCount;
		char inputMatrix[][] = new char[rowCount][columnCount];
		int tasksArray[][] = new int[noTasks][2];
		for(int i=0;i<rowCount;i++){
			
			String input = sc.next();
		
			for(int j=0;j<columnCount;j++){
				inputMatrix[i][j] = input.charAt(j);
			}
			
		}
		
		int sRow = sc.nextInt();
		int sColumn = sc.nextInt();
		initialI = sRow;
		initialJ = sColumn;
		for(int i=0;i<noTasks;i++){
			
				tasksArray[i][0] = sc.nextInt();
				tasksArray[i][1] = sc.nextInt();
				
			}
		
		
		for(int i=0;i<noTasks;i++){
			
			noOfSteps = 99999;
			travelledVertices.clear();
			System.out.println(findSteps(inputMatrix, sRow, sColumn, tasksArray[i][0], tasksArray[i][1],0));
			
			
		}
		
		//System.out.println(findSteps(inputMatrix, startI, startJ, endI, endJ));
	}

}
