package com.ankit.BackTrack;

public class Queen {
	
	int[][] queen=new int[8][8];
	int counter=1;
	
	public boolean isValidated(int row,int col){
		for(int i=0;i<=row-1;i++){
			for(int j=0;j<queen.length;j++){
				if(queen[i][j]==1){
					if(row==i || col==j || (i-row==j-col) || (i-row==col-j)) {
						
						return false;
					}
				}
				
			}
		}
		return true;
	}
	
	public boolean rule(int row,int col){
		if(row<queen.length && col<queen.length && isValidated(row,col)){
			return true;
		}
		return false;
		
	}
	
	public boolean placeQueen(int row){
		if(row==queen.length ){
			System.out.println("Solution :"+counter++);
			printSol();
			
			return false;
			
		}
		for(int j=0;j<queen.length;j++){
			if(rule(row,j)){
				queen[row][j]=1;
				if(placeQueen(row+1)) return true;
				queen[row][j]=0;
				
			}
		}
		return false;
		
	}
	
	public void placeQueenUtil(){
		for(int i=0;i<queen.length;i++){
			for(int j=0;j<queen.length;j++){
				queen[i][j]=0;
				}
				
			}
		placeQueen(0);
		}
	public void printSol(){
		for(int i=0;i<queen.length;i++){
			for(int j=0;j<queen.length;j++){
				System.out.print(queen[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Queen q = new Queen();
		q.placeQueenUtil();
		//q.printSol();

	}

}
