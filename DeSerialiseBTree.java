package com.leetcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DeSerialiseBTree {
	public static TreeNode readBtree(TreeNode node, Scanner scanner){
		String str = null;
		if(scanner.hasNext()){
			str = scanner.next();
			if(!str.equals("#")) {
				node = new TreeNode(Integer.parseInt(str));
				node.left = readBtree(node.left, scanner);
				node.right = readBtree(node.right, scanner);
				return node;
			}else
				return null;
		}else
			return null;
	}
	
	public static void printTree(TreeNode node){
		if(node==null)
			return;
		System.out.print(node.val+" ");
		printTree(node.left);
		printTree(node.right);
	}
	
	public static void main(String[] args){
		
		//Read
		Scanner scanner = null;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader("btree.ser")));
			TreeNode head = null;
			head = readBtree(head, scanner);
			printTree(head);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			scanner.close();
		}
		
	}
}
