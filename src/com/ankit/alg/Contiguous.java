package com.ankit.alg;

public class Contiguous {
	
public static int contiguousSum(int[] arr){
        
	
	int[] p=new int[arr.length];
	p[0]=arr[0];
	int max=Integer.MIN_VALUE;
	if(max<p[0]) max=p[0]; 
	for(int i=1;i<arr.length;i++){
		
		p[i]=Math.max(arr[i],arr[i]+p[i-1] );
		if(p[i]>max) max=p[i];
	}
	
	return max;
       
    }
	
	public static void main(String[] args) {
		int[] arr= {-2, -3, 4, -1, -2, 1, 5, -3};
		//int[] arr={2 ,-1 ,4};
		System.out.println(Contiguous.contiguousSum(arr));
	}

}
