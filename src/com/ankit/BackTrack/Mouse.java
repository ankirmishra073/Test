package com.ankit.BackTrack;

public class Mouse {
	int[][] sol=new int[4][4];
	int count=1;
	public boolean rule(int[][] prob,int i,int j){
		if(i<prob.length && j<prob.length && prob[i][j]==1) return true;
		return false;
	}
	public boolean findWay(int[][] prob,int i,int j){
		if(i==3 && j==3 && prob[3][3]==1){
			sol[i][j]=1;
			System.out.println("Sol:"+count++);
			printSol();
			return false;
		}
		if(rule(prob,i,j)){
			sol[i][j]=1;
			if(findWay(prob,i+1,j)) return true;
			if(findWay(prob,i,j+1)) return true;
			sol[i][j]=0;
			return false;
		}
		
		return false;
	}
	public void printSol(){
		for(int i=0;i<sol.length;i++){
			for(int j=0;j<sol.length;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public void findWayUtil(int[][] prob){
		for(int i=0;i<sol.length;i++){
			for(int j=0;j<sol.length;j++){
				sol[i][j]=0;
			}
		}
		System.out.println(findWay(prob,0,0));
		/*
		if(findWay(prob,0,0)) {
			System.out.println("solution exists");
			printSol();
		}
		else System.out.println("No solution");
		*/
		
	}

	public static void main(String[] args) {
	int[][] prob={{1,0,1,0},
			      {1,1,1,1},
	              {0,1,0,1},
	              {0,1,1,1}};
	Mouse m = new Mouse();
	
	m.findWayUtil(prob);

	}

}
