package tree;

public class tree {
	public static void main(String args[]){
		BinaryTree b1=new BinaryTree();
		b1.insert(10);
		b1.insert(4);
		b1.insert(11);
		b1.insert(3);
		BinaryTree b2=new BinaryTree();
		b2.insert(26);
		b2.insert(10);
		b2.insert(4);
		b2.insert(11);
		b2.insert(3);
		b2.insert(40);
		b2.insert(33);
		Checksubtree c=new Checksubtree();
		System.out.println(c.checktree(b2, b1));
	}
}

class Checksubtree{
	public boolean checktree(BinaryTree parent, BinaryTree child){
		System.out.println("Parent Inorder");
		String p1=parent.inorder();
		p1=p1.toString();
		
		System.out.println();
		System.out.println("Parent preorder");
		String p2=parent.preorder();
		p2=p2.toString();
		
		System.out.println();
		System.out.println("Child Inorder");
		String c1=child.inorder();
		
		
		System.out.println();
		System.out.println("Child Preorder");
		String c2=child.preorder();
		c2=c2.toString();
		
		System.out.println();
		if(p1.contains(c1) || p2.contains(c2)){
			System.out.println("The tree is a subtree");
		}
		else{
			System.out.println("Not a subtree");
		}
		return p1.contains(c1) || p2.contains(c2);
		
	}
}
class BinaryTree{
	private class Node{
		Node left;
		Node right;
		int data;
		Node(int newdata){
			left=null;
			right=null;
			data=newdata;
		}
	}
	private Node root;
	public void BinaryTree(){
		root=null;
	}
	
	public boolean lookup(int data){
		return lookup(root, data);
	}
	
	public boolean lookup(Node node, int data){
		if(node==null){
			return false;
		}
		if(data==node.data){
			return true;
		}
		else if(data<node.data){
			return lookup(node.left, data);
		}
		else{
			return lookup(node.right, data);
		}
	}
	
	public void insert(int data){
		Node temp=root;
		Node newnode=new Node(data);
		newnode.left=null;
		newnode.right=null;
		newnode.data=data;
		root=insert(root, newnode);
	}
	public Node insert(Node temp, Node newnode){
		int data;
		if(temp==null){
			temp=newnode;
		}
		else{
			if(temp.data<=newnode.data){
				insert(temp.right, newnode);
				if(temp.right==null)
					temp.right=newnode;
			}
			else{
				insert(temp.left, newnode);
				if(temp.left==null)
					temp.left=newnode;
			}
		}
		return temp;
	}
	
	public String preorder(){
		return preorder(root);
	}
	String s1=" ";
	
	public String preorder(Node node){
		if(node==null)
		{
			return null;
		}
			System.out.print(node.data+"\t");
			s1=s1+node.data;
			String pre=s1;
			preorder(node.left);
			preorder(node.right);
			return pre;
	}
	String s2=" ";
	public String inorder(){
		return inorder(root);
	}
	public String inorder(Node node){
		if(node==null)
		{
			return null;
		}
		inorder(node.left);
		System.out.print(node.data+"\t");
		s2=s2+node.data;
		String in=s2;
		inorder(node.right);
		return in;
	}
	public void isBalanced(){
		isBalanced(root);
	}
	public void isBalanced(Node root){
		int maxDepth=maxDepth(root);
		int minDepth=minDepth(root);
		System.out.println("Min Height:"+minDepth);
		System.out.println("Max height:"+maxDepth);
		if(maxDepth-minDepth<=1){
			System.out.println("Balanced Tree");
		}
		else{
			System.out.println("Unbalanced Tree");
		}
	}
	public int maxDepth(Node node){
		if(node==null){
			return 0;
		}
		int maxLeft=maxDepth((Node)node.left);
		int maxRight=maxDepth((Node)node.right);
		int max=Math.max(maxLeft, maxRight);
		return 1+max;
	}
	public int minDepth(Node node){
		if(node==null){
			return 0;
		}
		int minLeft=minDepth((Node)node.left);
		int minRight=minDepth((Node)node.right);
		int min=Math.min(minLeft, minRight);
		return 1+min;
	}
	
	//If we want to check if a tree is a subtree of parent tree then 
	//do the inorder, preorder of parent, sub trees and if the parent inrder contains subtree inorder
	//or parent preorder contains subtree preorder, then a tree is subtree 
}
