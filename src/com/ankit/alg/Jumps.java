package com.ankit.alg;
/**
 * 
 * @author mishraa
 *
 */
public class Jumps {
	
	public int getMinJumps(int[] arr,int i){
		if(i>=arr.length) return Integer.MAX_VALUE-1;
		if(i==arr.length-1) return 0;
		int min=Integer.MAX_VALUE;
		for(int j=i+1;j<=i+arr[i];j++){
		int valueAtNode=1+getMinJumps(arr,j);
		if(valueAtNode<min) min=valueAtNode;
		}
		return min;
		
		
	}
	/*
	 * try to make recursive tree 
	 * so we need to find things from back
	 * p[n]= for(j=n to j=j+arr[j]) ->    min(p[j])  
	 */
	public int getMinJumpsBottomUp(int[] arr){
		
		int[] p=new int[arr.length];
		p[arr.length-1]=0;
		
		for(int i=arr.length-2;i>=0;i--){
		int min=Integer.MAX_VALUE;
			for(int j=i+1;j<=i+arr[i];j++){
				if(j<arr.length){
				int valueAtNode=p[j];
				if(min>valueAtNode) min=valueAtNode;
				}
			}
			p[i]=min+1;
			
		}
			for(int i=arr.length-1;i>=0;i--){
		System.out.println(arr[i]+"--->"+p[i]);
			}
			return p[0];
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		Jumps j = new Jumps();
		//System.out.println(j.getMinJumps(arr, 0));
		j.getMinJumpsBottomUp(arr);

	}

}
