package com.ankit.alg;

public class Fibb {
	
	
	int getFibb(int n){
		int[][] f={{1,1},{1,0}};
		
		int[][] r=f;
		for(int i=2;i<n;i++){  // since for i=0 fib=0,i=1 fib=1,i=2 fib= 1
			r=multiply(r,f);
		}
		return r[0][0];
	}
	
	int[][] multiply(int[][] m,int[][] f){
		int[][] r=new int[2][2];
		r[0][0]=m[0][0]*f[0][0]+m[0][1]*f[1][0];
		r[0][1]=m[0][0]*f[0][1]+m[0][1]*f[1][1];
		r[1][0]=m[1][0]*f[0][0]+m[1][1]*f[1][0];
		r[1][1]=m[1][0]*f[0][1]+m[1][1]*f[1][1];
		return r;
		
	}
	
	
	int[][] getFibbRec(int n){
		
		if(n==0){
			int[][] f={{0,0},{0,0}};
			return f;
		}
		if(n==2 || n==1) {
			int[][] f={{1,1},{1,0}};
			return f;
		}

		
		if(n%2==0){
			
			int[][] r=getFibbRec(n/2);
		
			return multiply(r,r);
		}
		else{
			int[][] f={{1,1},{1,0}};
			return multiply(getFibbRec(n/2),f);
			
		}
		
	}

	public static void main(String[] args) {
		Fibb f = new Fibb();
		// 0 1 1 2 3 5
		int n=4;
		System.out.println(f.getFibbRec(n-1)[0][0]);
		System.out.println(f.getFibb(n));

	}

}
