package com.ankit.BinaryTree;

public class BTreeOperations {
	
	 
		public Node root;
		public static int w=0;
		
		public static int maxLevel;// for left view,right view
		/*
		 *          1
		 *       /      \
		 *     2         3
		 *      \       / \
		 *       5     6   4
		 *           	 
		 *           	  
		 */           
		
		public void populateTree(){
			
			root=new Node(1);
			Node a=new Node(2);
			Node b=new Node(3);
					root.left=a;
					root.right=b;
			Node c=new Node(4);
			Node d=new Node(5);
			        
			        a.right=d;
			Node e=new Node(6);
			    b.left=e;
			  b.right=c;
					
			
		}
		// print ancesstor of a key
        public boolean getAncesstor(Node node,int key){
        	if(node==null) return false;
        	if(node.data==key){
        		return true;
        	}
        	if(getAncesstor(node.left,key) ||getAncesstor(node.right,key)){
        		System.out.println(node.data);
        		return true;
        	}
        	
        	return false;
        }
		
		public int height(Node root){
			if(root==null) return 0;
			return Math.max(height(root.left),height(root.right))+1;
		}
		//n^2
		public int diameter(Node node){
			
			if(node==null) return 0;
			int lheight=height(node.left);
			int rheight=height(node.right);
			int ldiameter=diameter(node.left);
			int rdiameter=diameter(node.right);
			return Math.max(rheight+lheight+1,Math.max(ldiameter, rdiameter));
		}
				
		//n  need to work
		// dont need to calculate height every time, so need to return 2 values height, diameter
		// return array of size 2 for each node 
		public int[] diameterN(Node node){
			int[] result=new int[2];
			
			if(node==null) return result;
				int[] lResult  =diameterN(node.left);
				int[] rResult=  diameterN(node.right);
				
				int height= Math.max(lResult[0], rResult[1])+1;
				
				int ldiameter=lResult[1];
				int rdiameter=rResult[1];
				result[0]=height;
				result[1]=Math.max(lResult[0]+rResult[0]+1,Math.max(ldiameter, rdiameter));
				
				return result;
				
				
				
				
			
		}
		
		// n^2
		public int getMaxWidth(Node node){
			int max=Integer.MIN_VALUE;
			for(int i=1;i<=height(node);i++){
				 width(node,i);
				 if(max<w) max=w;
				 w=0;
			}
			return max;
		}
		
		public void width(Node node,int level)
		{
			if(node==null) return;
			
			if(level==1){
				 w++;
			}
			width(node.left,level-1);
			width(node.right,level-1);
			
			
			
		}
		
		// n
		public void getMaxWidthN(Node node ){
			
			int h=height(node);
			int[] count=new int[h];
			int level=0;
			
			preOrderCount(node,count,level);
			
			
			
			
			
		}

	public void preOrderCount(Node node, int[] count, int level) {
			if(node==null) return;
			else{
				count[level]++;
				preOrderCount(node.left,count,level++);
				preOrderCount(node.right,count,level++);
			}
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTreeOperations b = new BTreeOperations();
		b.populateTree();
		System.out.println(b.diameter(b.root));
		System.out.println(b.diameterN(b.root)[1]);
		//System.out.println(b.getMaxWidth(b.root));
	//b.getAncesstor(b.root, 6);

	}

}
