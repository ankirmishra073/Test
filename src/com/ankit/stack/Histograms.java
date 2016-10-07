package com.ankit.stack;

public class Histograms {
	
	// refer http://tech-queries.blogspot.in/2011/03/maximum-area-rectangle-in-histogram.html
	// refer only li ri concept
	public int findLargestRectangle(int[] hist){
		// first find li
		int[] l=new int[hist.length];
		l[0]=0;
		for(int i=1;i<l.length;i++){
			if(hist[i]<=hist[i-1]) l[i]=l[i-1]+1;
			else l[i]=0;
			
		}
		
		
		// find ri
		int[] r=new int[hist.length];
		r[hist.length-1]=0;
		for(int i=hist.length-2;i>=0;i--){
			
			if(hist[i]<=hist[i+1]) r[i]=r[i+1]+1;
			else r[i]=0;
		}
		
		
		int[] area=new int[hist.length];
		int max=-1;
		for(int i=0;i<area.length;i++){
			
			area[i]=(l[i]+r[i]+1)*hist[i];
			if(max<area[i]) max=area[i];
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] hist = {6, 2, 5, 4, 5, 1, 6};
		Histograms h = new Histograms();
	System.out.println(h.findLargestRectangle(hist));
		
	}

}
