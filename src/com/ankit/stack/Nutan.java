package com.ankit.stack;

public class Nutan {

	
	public void suffle(String s1){
		System.out.println("             "+s1);
		if(s1.length()==1){
			System.out.print(s1);
			return;
		}
			
			for(int i=1;i<s1.length();i++){
				
				suffle(s1.substring(i,s1.length()));
				suffle(s1.substring(0, i));
				System.out.println();
				
				
			}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="great";
		//System.out.println(s.substring(, s.length()));
		Nutan n = new Nutan();
		n.suffle(s);

	}

}
