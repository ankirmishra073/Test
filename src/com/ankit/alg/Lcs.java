package com.ankit.alg;

public class Lcs {

	

	
	public int lcsRecursive(String s1,String s2, int m,int n){
		
		if(m<0 || n<0) return 0;
		
		if(s1.charAt(m)==s2.charAt(n)) return 1+lcsRecursive(s1,s2,m-1,n-1);
		return Math.max(lcsRecursive(s1,s2,m-1,n), lcsRecursive(s1,s2,m,n-1));
		
	}
	
	
	public int lcsBottomUp(String s1,String s2)
	{
		
		/*
		 * 
		 * Convenient approach but for every i-1 need to check if it is <0
		 
		 int m=s1.length()-1;
		int n=s2.length()-1;
		int[][] p =new int[m+1][n+1];
		
			
		for(int i=0;i<=m;i++){
			
			for(int j=0;j<=n;j++){
			
			if(s1.charAt(i)==s2.charAt(j))
				 {
					 p[i][j]=1+  ((i-1<0 || j-1<0)? 0:p[i-1][j-1]);
					
				 }
				
				 else
				 {
					
						 p[i][j]=Math.max(i-1<0 ? 0: p[i-1][j] ,j-1<0 ? 0 : p[i][j-1]);
					 
				 }
			}
			}
			return p[m][n];
			}
		 */
		//initialize p with 1 extraa size where p[0][i] and p[i][0]=0
		int m=s1.length();
		int n=s2.length();
		int[][] p =new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			
			for(int j=0;j<=n;j++){
				
				if (i == 0 || j == 0)
			         p[i][j] = 0;
			  
			       else if (s1.charAt(i-1) == s2.charAt(j-1)) // since already i is 1 + extraa so need to check i-1
			         p[i][j] = p[i-1][j-1] + 1;
			  
			       else
			         p[i][j] = Math.max(p[i-1][j], p[i][j-1]);
			         
				
				
			}
		}
			
	
				
			
		
		return p[m][n];
	}

	public static void main(String[] args) {
		Lcs lcs = new Lcs();
		String s1="LAGGTAB";
		String s2="ATGXTXAYB";
		//System.out.println(lcs.lcsRecursive(s1, s2,s1.length()-1, s2.length()-1));
		System.out.println(lcs.lcsBottomUp(s1, s2));
 

	}

}
