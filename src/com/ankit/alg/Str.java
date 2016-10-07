package com.ankit.alg;

public class Str {
	public int[][] value;
	public Str(){
		super();
	}
	public Str(int[][] value){
		this.value=value;
	}

	public boolean isPal(String s,int i,int j){
		
		while(i<=j){
			if(s.charAt(i)!=s.charAt(j)) return false;
				i++;
				j--;
		}
		return true;
	}
public void findPalindrome(String s){
	int min=0;
	int in = 0;
	int fi=0;
	for(int i=0;i<s.length();i++){
		for(int j=i;j<s.length();j++){
			boolean pal = isPal(s,i,j);
			//System.out.println(pal);
			if(pal){
				int l=j-i+1;
				if(l>min){
					min=l;
					in=i;
					fi=j;
				}
				//System.out.println(s.substring(i, j+1));
			}
			
		}
	}
	System.out.println(min);
	System.out.println(s.substring(in, fi+1));
	
	
}

public int longPalindrome(String s,int i,int j){
	
	if(i==j) return 1;
	if(s.charAt(i)==s.charAt(j) && j-i==1 ) return 2;
	//if(i<j){
		if(s.charAt(i)==s.charAt(j)) return 2+longPalindrome(s, i+1, j-1);
		
		return Math.max(longPalindrome(s, i, j-1), longPalindrome(s, i+1, j));
	//}
	//return 1;
}

/*
 * longest palindrome subsequence via DP
 */
public int lcsTopDown(String s,int i,int j){
	
	if(i==j) 
		{
		value[i][j]=1;
		return 1;
		}
	if(i<j){
		if(s.charAt(i)==s.charAt(j))
			
		{ 
			if(value[i+1][j-1]!=0) {
			return 2+value[i+1][j-1];
			}
			else{
				value[i+1][j-1]=lcsTopDown(s, i+1, j-1);
			return 2+value[i+1][j-1];
			}
		}
		return Math.max(lcsTopDown(s, i, j-1), lcsTopDown(s, i+1, j));
	}
	
	return 0;
}
	

public void test(){
	
	int gap=1;
	while(gap<=9){
		for(int j=0;j+gap<=9;j++){
			
			System.out.println(j+"   "+(j+gap));
		}
		gap++;
		
	}
	
}

public int lcsBottomUp(String s){
	int n=s.length()-1;
	int[][] mem=new int[n+1][n+1];
	for(int i=0;i<=n;i++){
		mem[i][i]=1;
	}
	
	int gap=1;
	/*
	 * loop like pattern 01,11,12,13,14,15 then 02,13,
	 */
	while(gap<=n){
		for(int j=0;j+gap<=n;j++){
			int last=j+gap;
			
			if(s.charAt(j)==s.charAt(last) && gap==1)  mem[j][last]=2;
			
			
			else if(s.charAt(j)==s.charAt(last)) mem[j][last]=mem[j+1][last-1]+2;
			
			else mem[j][last]=Math.max(mem[j+1][last], mem[j][last-1]);
			
		}
		gap++;
		
	}
	
	return mem[0][n];
}

public static void main(String[] args) {
		// TODO Auto-generated method stub

//String s="albllbkhfkldhsfiowhfmvhjaghhlyt";
//String s="adsjxtkdjllblltk";
String s="GEEKSFORGEEKS";
//		String s="adlbtda";
		//2+dlbtd
		  //2+lbt
		  //  lb  bt
		   // l b  b t
		   // 1 1  1 1
		


//Str str = new Str();
//System.out.println(str.lcsBottomUp(s));
//str.findPalindrome(s);
//System.out.println(str.longPalindrome(s, 0, s.length()-1));
int[][] value=new int[s.length()-1][s.length()-1];
Str str = new Str(value);
System.out.println(str.lcsTopDown(s, 0, s.length()-1));

	}

}
