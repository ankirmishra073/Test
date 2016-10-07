package com.ankit.alg;

public class Splitter {
	
	
	
	/*problem :  https://www.hackerrank.com/challenges/array-splitting
	 * p(k,n)=  if k=n return 0;
	 *           1+max[max[p(k,n-i),p(n-i+1,n)]] for i=1 to  n whre  for each i p(k,n,i) should be splitable
	 */
	
	
	
	public int maxSplitterBottomUp(int [] arr,int k,int n){
	int[][] p=new int[n+1][n+1];
	for(int i=0;i<=n;i++){
		p[i][i]=0;
	}
	int gap=1;
	while(gap<=n)
	{
		for(int x=0;x+gap<=n;x++){
			int y=x+gap;
			
			int max=0;
			
			for(int i=x;i<y;i++){
				int valueAtThisNode=0;
				if(isSplitable(arr, x, y, i)) valueAtThisNode=1+Math.max(p[x][i], p[i+1][y]);
				if(max<valueAtThisNode) max=valueAtThisNode;
			}
		
			p[x][y]=max;
		}
		gap++;
	}
		return p[0][n];
		
	}
	
	public int maxSplitter(int[] arr,int k,int n){
        if(k==n) return 0;
        int max=0;
        for(int i=n-1;i>=0;i--){
            if(isSplitable(arr,k,n,i))
            {
                int maxAtThisNode=0;
                
                maxAtThisNode= 1+ Math.max(maxSplitter(arr,k,i),maxSplitter(arr,i+1,n));
                if(maxAtThisNode>max) max=maxAtThisNode;
            }
        }
        
        return max;
    }

	
	
public  int findScore(int[] a,int l, int r)
{
        
	 if((r-l) == 0)
         return 0;
     int sumL = 0;
     int sumR = 0;
     int i = l;
     int j=r;
     while(i < j){
         if(sumL <= sumR && i != j-1){
             sumL+=a[++i];
         }
         else if(sumL > sumR && i != j-1){
             sumR+=a[--j];
         }
         else
             break;
     }
     if(sumL == sumR){            
             return 1 + Math.max(findScore(a , i+1 , r),findScore(a , l , i));
     }
     return 0;
    }
    
	
	
	
	
	public boolean isSplitable(int[] arr, int k, int n,int i) {
		int firstSum=0;
		int lastsum=0;
		for(int j=k;j<=i;j++) firstSum+=arr[j];
		for(int j=i+1;j<=n;j++) lastsum+=arr[j];
		return firstSum==lastsum;
		
		
	}

	public static void main(String[] args)
	{
		Splitter sp = new Splitter();
		//int[] arr={4,1,0,1,1,0,1};
		
		int[] arr={1,1,2,4,8};
		
	//	int[] arr={1,1,1,0,2,1};
		
		//int[] arr={2,2,2,2,1,1,1,1,1,1,1,1};
		System.out.println(sp.maxSplitter(arr, 0, arr.length-1));
		System.out.println(sp.maxSplitterBottomUp(arr, 0,  arr.length-1));
System.out.println(sp.findScore(arr,0,arr.length-1));
	}

}
