package com.ankit.alg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Egg {
	
	
	
	
	
public int minEggStrategyRecursive(int k,int n) throws InterruptedException{
		
		
		if(k==1 || k==0) return k;
		
		if(n==1) return k;  // if 1 egg remaining
		
		
		
		int min=Integer.MAX_VALUE,valueAtThisNode;
		for(int i=1;i<=k;i++)
		{
			
					valueAtThisNode=1+Math.max(minEggStrategyRecursive(i-1,n-1),minEggStrategyRecursive(k-i,n));
					if(valueAtThisNode<min) min=valueAtThisNode;
					
		}
		return min;
	}



public int minEggStrategyBottomUp(int k,int n){
	
	int[][] p=new int[k+1][n+1];
	for(int i=0;i<=n;i++){
		p[0][i]=0;
		p[1][i]=1;
	}
	for(int i=0;i<=k;i++){
		p[i][1]=i;
	}
	
	for(int i=2;i<=k;i++){
		
		for(int j=2;j<=n;j++){
			int min=Integer.MAX_VALUE;
			
			for(int x=1;x<=i;x++)
			{
				
				int valueAtThisNode=1+Math.max(p[x-1][j-1], p[i-x][j]);
				if(valueAtThisNode<min) min =valueAtThisNode;
		}
			p[i][j]=min;
			
		}
	}
	return p[k][n];
	
}



public int minEggStrategyBottomUpWithSteps(int k,int n){
		
	
	
	int[][] p=new int[k+1][n+1];
	for(int i=0;i<=n;i++){
		p[0][i]=0;
		p[1][i]=1;
	}
	for(int i=0;i<=k;i++){
		p[i][1]=i;
		
	}
	
	for(int i=2;i<=k;i++){
		
		for(int j=2;j<=n;j++){
			int min=Integer.MAX_VALUE;
			int step=0;
			
			for(int x=1;x<=i;x++)
			{
				
				int valueAtThisNode=1+Math.max(p[x-1][j-1], p[i-x][j]);
				if(valueAtThisNode<min) {
					step=x;
					min =valueAtThisNode;
				}
		}
			System.out.print("i="+i+ "   Steps:"+step);
			p[i][j]=min;
			
		}
		System.out.println();
	}
	return p[k][n];
	
}
 
	public static void main(String[] args) throws InterruptedException {
		Egg egg = new Egg();
		
		//System.out.println(egg.minEggStrategyRecursive(10, 2));
		//System.out.println(egg.minEggStrategyBottomUp(100, 2));
		egg.minEggStrategyBottomUpWithSteps(100, 2);

	}

}
