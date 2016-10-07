package com.ankit.alg;

import java.util.HashMap;
import java.util.Map;

public class Lis {
	
	
	int[] p;
	public Lis(int n){
		this.p=new int[n];
	}
	
	
	public Lis() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	public int longestIncreasingSubViaTopDownDP(int[] arr, int i){
		int maxAtThisLevel=-1;
		if(i==0){
			System.out.println("here");
			p[0]=1;
			return 1;
		}
		for(int j=i-1;j>=0;j--){
			int valueAtNode=1;
			if(arr[i]>arr[j]){
				if(p[j]!=0){
					valueAtNode=p[j]+1;
					
				}
				else
				{
					valueAtNode=longestIncreasingSubViaTopDownDP(arr,j)+1;
					
				}
				
			}
			if(valueAtNode>maxAtThisLevel) maxAtThisLevel=valueAtNode;
		}
		p[i]=maxAtThisLevel;
		return p[i];
		
	}
	
	public int longestIncreasingSubViaTopDownDPUtil(int[] arr){
		longestIncreasingSubViaTopDownDP(arr,arr.length-1);
		
		return p[arr.length-1];
	}
	public int longestIncreasingSub(int[] arr,int i){
		int maxAtThisLevel=-1;
		if(i==0) return 1;
		for(int j=i-1;j>=0;j--){
			int valueAtNode=1;  // think if arr={11,3} then it should give lis=1
			
			if(arr[i]>arr[j]) valueAtNode=longestIncreasingSub(arr,j)+1;
			if(valueAtNode>maxAtThisLevel) maxAtThisLevel=valueAtNode;
		}
		return maxAtThisLevel;
	}
	
	public int lisBottomUp(int[] arr){
		int[] p=new int[arr.length];
		p[0]=1;
		int j;
		
		
		for(int i=1;i<=arr.length-1;i++){
			j=i-1;
			int max=0;
			while(j>=0){
				if(arr[j]<arr[i] && p[j]>max) max=p[j]; 
				j--;
			}
			
			p[i]=1+max;
				
		}
		/* ref purpose only ,which helps to determine list also
		for(int i=0;i<p.length;i++){
			System.out.print("p["+i+"]"+p[i]+"    ");
		}
		System.out.println();
		*/
		int maxLis=Integer.MIN_VALUE;
		int index=-1;
		for(int i=0;i<=arr.length-1;i++){
			if(p[i]>maxLis) {
				maxLis=p[i];
				index=i;
			}
		}
		printLisSequence(arr,p,index);
		
		
		return maxLis;
	}
	/*
	 * 
	 * idea is to find max value in p[] , then from that index iterate to back side and find its predecessor ie; p[]-1
	 * better to look in all values of p[], likw in this example find 4,3,2,1
	 * if value of p[]=1 then coming from last to intial ,break the loop when you get first p[]=1
	 */
	public void printLisSequence(int[] arr,int[] p,int index){
		int maxValue=p[index];
		System.out.println(arr[index]);
		maxValue--;
		index--;
		while(maxValue>=1){
			if(maxValue==p[index]) {
				System.out.println(arr[index]);
				if(maxValue==1)  return ;
				maxValue--;
				index--;
			}
			else index--;
		}
		
	}
	
/*
 * lis with nlogn , return size of  lis
 */
	
	public int lisNLogN(int[] arr){
		
		int[] temp=new int[arr.length];
		temp[0]=arr[0];
		
		int index;
		int last=0;
		
		
		
		for(int i=1;i<arr.length;i++){
			
			index=doBinarySearch(temp,arr[i],last);
		//	System.out.println(index);
			if(index!=-1){
				if(index>=last) last=index;
				temp[index]=arr[i];

				
				
			}
			
			/* see how list getting modified
			for(int j=0;j<=last;j++){
				System.out.print(temp[j]+",");
			}
			System.out.println();
			*/
			
		}
		return last+1;
		
	}
	
	/*
	 * Lis nlogn , return list of numbers also
	 */
	public int lisNLogNList(int[] arr){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int[] temp=new int[arr.length];
		temp[0]=arr[0];
		
		map.put(temp[0], -1);
		int index;
		int last=0;
		
		
		
		for(int i=1;i<arr.length;i++){
			
			index=doBinarySearch(temp,arr[i],last);
		//	System.out.println(index);
			if(index!=-1){
				if(index>=last) last=index;
				temp[index]=arr[i];
				if(index==0) map.put(temp[index], -1);
				else map.put(temp[index], temp[index-1]);
				
				
			}
			System.out.println(map.toString());
			/* see how list getting modified
			for(int j=0;j<=last;j++){
				System.out.print(temp[j]+",");
			}
			System.out.println();
			*/
			
		}
		return last+1;
		
	}	
	public int doBinarySearch(int[] temp,int value,int last){
	if(value>temp[last]) return last+1;
	if(value<temp[0]) return 0;
	int first=0;
	
	int mid=-1;
	while(first<=last)
	{
		
		mid=(first+last)/2;
		if(mid>0 && value<=temp[mid] && value>temp[mid-1]) return mid; // if value is in between
		else if(value>temp[mid]) {
			first=mid+1;
			
		
		}
		else {
			last=mid-1;
			
		}
		
	}
	return -1;
	
	
	}
	// its a exact binary search
	/*
		public int doBinarySearch(int[] temp,int value){
			int first=0;
			int last=temp.length-1;
			int mid=-1;
			if(temp[first]==value) return first;
			if(temp[last]==value) return last;
			
			while(first<=last)
			{
				
				mid=(first+last)/2;
				if(temp[mid]==value) return mid;
				else if(value>temp[mid]) {
					first=mid+1;
					
				
				}
				else {
					last=mid-1;
					
				}
				
			}
			return -1;
			
		}
		
	*/
	
	
	public static void main(String[] args) {
		
		int[] arr={110, 22, 9, 33, 21, 50, 41, 6};
		
		//int[] arr={6,8,10,12,15};
		
		
		//Lis lis = new Lis();
		//System.out.println(lis.longestIncreasingSub(arr, arr.length-1));
		
		//Lis lis = new Lis(arr.length);
		//System.out.println(lis.longestIncreasingSubViaTopDownDPUtil(arr));
		
		Lis lis = new Lis();
		lis.lisNLogN(arr);
		//System.out.println(lis.doBinarySearch(arr, 12));
	//lis.lisBottomUp(arr);
		

	}

	
}
