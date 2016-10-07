package com.ankit.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 
 * @author mishraa
 *  Only about btree traversal
 */
public class BTree {
	 
	public Node root;
	
	public static int maxLevel;// for left view,right view
	
	public static int minWidth;  // for top view
	public static int maxWidth;
	/*
	 *          1                    1
	 *       /      \			   /   \
	 *     2         3			3		2
	 *      \       /		     \	   /
	 *       5     6		  	  6   5
	 *            /					\
	 *           4                   4
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
		    e.left=c;
				
		
	}
	
	

	
	public void preOrder(Node root){
		if(root==null) return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	public void postOrder(Node root){
		if(root==null) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	public void inOrder(Node root){
		if(root==null) return;
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
		
	}
	
	
	public void inOrderNonRec(Node node){
		
		Stack<Node> stack=new Stack<Node>();
		stack.add(node);
		Node curr=node.left;
		while(!stack.isEmpty() || curr!=null)
		{
		while(curr!=null){
			
			stack.add(curr);
			curr=curr.left;
		}
		curr=stack.pop();
		System.out.println(curr.data);
		curr=curr.right;
		}
		
		
	}
	
	public void leftView(Node root,int level){
		 if(root==null) return;
		 if(level>maxLevel) {
			 System.out.println(root.data);
			 maxLevel=level;
		 }
		 leftView(root.left,level+1);
		 leftView(root.right,level+1);
		
	}
	
	public void rightView(Node root,int level){
		 if(root==null) return;
		 if(level>maxLevel) {
			 System.out.println(root.data);
			 maxLevel=level;
		 }
		 leftView(root.right,level+1);
		 leftView(root.left,level+1);
		
	}
	
	public void levelOrderUsingQueue(Node root){
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		
		
		Node curr;
		while(!queue.isEmpty()){
			curr=queue.poll();
			System.out.println(curr.data);
			if(curr.left!=null) queue.add(curr.left);
			if(curr.right!=null) queue.add(curr.right);
		}
		
		
	}
	
	
	public void levelOrderUsingRec(Node root,int level){
		if(root==null) return;
		if(level==1) {
			System.out.print(root.data+"   ");
			return ;
		}
		levelOrderUsingRec(root.left,level-1);
		levelOrderUsingRec(root.right,level-1);
	}
	
	public void levelOrderUsingRecUtil(){
		for(int i=1;i<=height(root);i++){
		levelOrderUsingRec(root,i);
		System.out.println();
		}
	}
	
	
	public int height(Node root){
		if(root==null) return 0;
		return Math.max(height(root.left),height(root.right))+1;
	}
	//need to work
	public void zigZagViewUsingStack(Node root) throws InterruptedException{
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
		while(!s1.isEmpty()){
			Node popped=s1.pop();
			System.out.print(popped.data+" ");
			if(popped.left!=null) s2.push(popped.left);
			if(popped.right!=null) s2.push(popped.right);
		}
		System.out.println();
		while(!s2.isEmpty()){
			Node popped=s2.pop();
			System.out.print(popped.data+" ");
			if(popped.right!=null) s1.push(popped.right);
			if(popped.left!=null) s1.push(popped.left);
		}
	   
		System.out.println();
		}
		
	}
public void topView(Node node){
	
	Queue<NodeH> queue=new LinkedList<NodeH>();
	Map<Integer,Node> map=new TreeMap<Integer,Node>();
	queue.add(new NodeH(node,0));
	while(!queue.isEmpty()){
		
		NodeH n=queue.poll();
		if(!map.containsKey(n.width)){
		map.put(n.width, n.node);
		}
		
		if(n.node.left!=null) queue.add(new NodeH(n.node.left,n.width--));
		if(n.node.right!=null) queue.add(new NodeH(n.node.right,n.width++));
	
	}
		
		for (Node n : map.values()) {
			
			System.out.println(n.data);
		}
		
	
}

public Node mirrorTree(Node node){
	
	if(node==null) return null;
	
	Node leftTree=mirrorTree(node.left);
	Node rightTree=mirrorTree(node.right);
	
	node.right=leftTree;
	node.left=rightTree;
	return node;
	
}



public void topViewRecursive(Node node){
	
	
}
	
	
	boolean checkBSTUtil(Node n,int min,int max){
        if(n==null) return true;
        if(n.data>max) return false;
        if(n.data<min) return false ;   
       return(checkBSTUtil(n.left,min,n.data-1) &&
        checkBSTUtil(n.right,n.data+1,max));
       
    }


    boolean checkBST(Node root) {
        return checkBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
	public static void main(String[] args) throws InterruptedException {
		BTree bTree = new BTree();
		bTree.populateTree();
		//bTree.preOrder(bTree.root);
		//System.out.println("******************");
		//bTree.mirrorTree(bTree.root);
		//bTree.preOrder(bTree.root);
		//bTree.postOrder(bTree.root);
		bTree.inOrderNonRec(bTree.root);
		System.out.println("******************");
		bTree.inOrder(bTree.root);
		
		//bTree.rightView(bTree.root, 1);
		//bTree.levelOrderUsingQueue(bTree.root);
		//bTree.zigZagViewUsingQueue(bTree.root);
		//bTree.levelOrderUsingRecUtil();
		//System.out.println(bTree.height(bTree.root));
		//bTree.zigZagViewUsingStack(bTree.root);
		//bTree.topView(bTree.root);
	}

}
