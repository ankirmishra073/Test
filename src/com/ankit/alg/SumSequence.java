package com.ankit.alg;

/**
 * 
 * @author mishraa
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 *
 */
public class SumSequence {
	
	public int getMaxSumSequence(int[] arr){
		int[] p=new int[arr.length];
		p[0]=arr[0];
		int max=p[0];
		for(int i=1;i<arr.length;i++){
			
			for(int j=i-1;j>=0;j--){
				if(arr[i]>arr[j]){
					p[i]=arr[i]+p[j];
					if(max<p[i]) max=p[i];
					break;
				}
				else  p[i]=arr[i];  
				
			}
			
		}
		return max;
	}

	public static void main(String[] args) {
		//int arr[] = {1, 101, 2, 3, 100, 4, 5};
		int arr[]={10, 5, 4, 3};
		SumSequence s = new SumSequence();
		System.out.println(s.getMaxSumSequence(arr));

	}

}
