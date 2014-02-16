package tree;

public class tree {
	public static void main(String args[]){
		BinaryTree b=new BinaryTree();
		b.insert(4);
		b.insert(5);
		b.insert(2);
		/*b.insert(2);
		b.insert(4);
		b.insert(3);
		b.insert(3);*/
		b.preorder();
		b.isBalanced();
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
	
	public void preorder(){
		preorder(root);
	}
	
	public void preorder(Node node){
		if(node==null)
		{
			return;
		}
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
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
}
