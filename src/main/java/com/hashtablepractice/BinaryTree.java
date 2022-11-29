package com.hashtablepractice;

public class BinaryTree<K extends Comparable<K>> {
	
	private class TreeNode<K extends Comparable<K>>{
		K data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(K data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	TreeNode root;
	
	BinaryTree()
	{
		this.root = null;
	}
	
	private TreeNode insert(TreeNode<K> tempnode,K data)
	{
		if(tempnode == null || tempnode.data == data)
		{
			tempnode = new TreeNode(data);
			return tempnode;
		}
		
		if(data.compareTo(tempnode.data) < 0)
			tempnode.left = insert(tempnode.left,data);
		else
			tempnode.right = insert(tempnode.right,data);
		return tempnode;
	}
	
	public void add(K data)
	{
//		this.root = insert(root,data);
		if(this.root == null)
		{
			root = new TreeNode(data);
			return;
		}
		TreeNode<K> slast = this.root;
		TreeNode<K> last = data.compareTo(slast.data) < 0 ? slast.left : slast.right;
		while(true)
		{	
			if(last == null)
			{
				if(data.compareTo(slast.data) < 0)
					slast.left = new TreeNode(data);
				else
					slast.right = new TreeNode(data);
				return;
			}
			slast = data.compareTo(slast.data) < 0 ? slast.left : slast.right;
			last = data.compareTo(slast.data) < 0 ? slast.left : slast.right;
		}
	}
	
	private void inorder(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public void display()
	{
		inorder(this.root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree bt = new BinaryTree();
		bt.add(56);
		bt.add(30);
		bt.add(70);
		bt.display();
	}

}

	