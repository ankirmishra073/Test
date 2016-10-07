package com.ankit.alg;

public class Rod {
	
	
	public int cuttingRod(int[] rod,int n){
		
		if(n<=0) return 0;
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			
			int valueaAtThisNode=rod[i-1]+cuttingRod(rod,n-i);
			if(valueaAtThisNode>max) max=valueaAtThisNode;
			
		}
		return max;
	}
	
public int cuttingRodwithBottomUp(int[] rod,int n){
		
		int[] p=new int[n+1];
		
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			int valueaAtThisNode;
			System.out.println("max="+max+"   rod[i-1]:"+rod[i-1]+"   p[n-i]:"+p[n-i]);
			valueaAtThisNode=rod[i-1]+p[n-i];
			
			if(valueaAtThisNode>max){
				max=valueaAtThisNode;
			}
			p[i]=max;
			System.out.println("p["+i+"]"+p[i]);
			
		}
		return p[n];
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rod={1,5,8,9,10,17,17,20};
		Rod r = new Rod();
		System.out.println(r.cuttingRod(rod, 6));
		System.out.println(r.cuttingRodwithBottomUp(rod, 6));
		//  1,p(7)  5,p(6) 8,p(5) 9,p(4)  10,p(3)  17,p(2) 17,p(1)  20,p[0]
		
		//p[1]=1;          p[1]=max(0,1+p[0])=1
		//p[2]=5+p[1]=6    p[2]=max(1,5+p[1])
		//p[3]=8+p[2]=13
		//p[4]=9+p[3]=22
				

	}

}
