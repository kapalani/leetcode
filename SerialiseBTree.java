package com.leetcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SerialiseBTree {
	
	public static void writeBtree(TreeNode node, PrintWriter writer){
		if(node==null)
			writer.print("# ");
		else {
			writer.print(node.val+" ");
			writeBtree(node.left, writer);
			writeBtree(node.right, writer);
		}
	}
	
	public static void printTree(TreeNode node){
		if(node==null)
			return;
		System.out.print(node.val+" ");
		printTree(node.left);
		printTree(node.right);
	}
	
	public static void main(String[] args){
		//Write
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("btree.ser");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot create file");
		}
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		
		printTree(root);
		
		writeBtree(root, writer);
		writer.close();
		
	}
}
