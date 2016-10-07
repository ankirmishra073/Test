package com.ankit.alg;

public class Coin {
	
	public int coinsSets(int[] coins,int m,int n){
		if(n==0) 
			return 1;
		
		if(n<0 || m<0) return 0;
	
		return coinsSets(coins,m,n-coins[m])+coinsSets(coins,m-1,n);
		
		
	}

	// p[m][n]=p[m][n-arr[m]]+p[m-1][n]   
	//p[m][0]=1
	public int coinsSetsBottomUp(int[] coins,int n){
		int m=coins.length-1;
		int x,y;
		int[][] p=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			p[i][0]=1;
		}
		for(int i=0;i<=m;i++){
			for(int j=1;j<=n;j++){
				
				x=i-1>=0 ? p[i-1][j]:0;
				y=j-coins[i]>=0 ? p[i][j-coins[i]]:0;
				p[i][j]=x+y;
				
			}
		}
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				
				System.out.print(p[i][j]+" ");
				
			}
			System.out.println();
			}
			
		
		return p[m][n];
		
		
	}
	
	public int minCoinsSets(int[] coins,int m,int n){
		
		
		if(n==0) return 0;
		
		if(m<0 || n<0) return Integer.MAX_VALUE-1;
		
		
		return Math.min(1+minCoinsSets(coins,m,n-coins[m]),minCoinsSets(coins,m-1,n));
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coin c = new Coin();
		int[] coins={1,2,4,6};
		//System.out.println(c.coinsSets(coins,coins.length-1 ,7));
		System.out.println(c.coinsSetsBottomUp(coins, 4));
		//System.out.println(c.minCoinsSets(coins,coins.length-1, 7));
		//System.out.println(Math.min(1,Integer.MAX_VALUE+1));
		

	}

}
