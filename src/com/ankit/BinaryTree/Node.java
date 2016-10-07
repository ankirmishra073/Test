package com.ankit.BinaryTree;

public class Node {
	
	public Node left;
	public Node right;
    public int data;
	public Node(Node left, Node right, int data) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}
	public Node(int data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
    
}
