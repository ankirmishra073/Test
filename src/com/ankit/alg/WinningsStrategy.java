package com.ankit.alg;

public class WinningsStrategy {

	
	//http://tech-queries.blogspot.in/search/label/Google%20Interview
	public int getMaxSum(int[] coins,int i,int j){
		
		if(i>j) return 0;
		int first=coins[i]+Math.max(getMaxSum(coins,i+2,j), getMaxSum(coins,i+1,j-1));// getMaxSum(coins,i+1,j-1)it can calculate once
		int second=coins[j]+Math.max(getMaxSum(coins,i,j-2),getMaxSum(coins,i+1,j-1));
	
		return Math.max(first,second);
		

		
	}
	
	
	
	public int getMaxSumViaDp(int[] coins){
		int[][] value=new int[coins.length][coins.length];
		int gap=1;
		while(gap<=coins.length-1){
			for(int i=0;i+gap<coins.length;i++){
				
				int j=i+gap;
				
				int x=coins[i]+Math.max(i+2>j?0:value[i+2][j], i+1>j-1?0:value[i+1][j-1]);
				int y=coins[j]+Math.max(i>j-2?0:value[i][j-2], i+1>j-1?0:value[i+1][j-1]);
				value[i][j]=Math.max(x, y);
				
			}
			gap++;
			
		}
		return value[0][value.length-1];
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] arr={3, 2, 2, 3, 1, 2};
WinningsStrategy w = new WinningsStrategy();
System.out.println(w.getMaxSum(arr, 0, arr.length-1));
System.out.println(w.getMaxSumViaDp(arr));
	}

}
