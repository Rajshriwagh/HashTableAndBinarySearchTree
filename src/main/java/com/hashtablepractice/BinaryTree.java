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
	int size = 0;
	
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
		if(this.root == null)
		{
			root = new TreeNode(data);
			size++;
			return;
		}
		TreeNode<K> slast = this.root;
		TreeNode<K> last = data.compareTo(slast.data) < 0 ? slast.left : slast.right;
		while(true)
		{	
			if(data.compareTo(slast.data) == 0)
				return;
			if(last == null)
			{
				if(data.compareTo(slast.data) < 0)
					slast.left = new TreeNode(data);
				else
					slast.right = new TreeNode(data);
				size++;
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
	
	public void size()
	{
		System.out.println("size is " + this.size);
	}
	
	public int search(Integer data)
	{
		if(this.root == null)
			return 0;
		TreeNode temp = this.root;
		while(temp != null)
		{
			if(temp.data == data)
				return data;
			temp = temp.data.compareTo(data) < 0 ? temp.right : temp.left;
		}
		return 0;
	}

	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.add(56);
		bt.add(30);
		bt.add(22);
		bt.add(40);
		bt.add(11);
		bt.add(3);
		bt.add(16);
		bt.add(70);
		bt.add(95);
		bt.add(60);
		bt.add(65);
		bt.add(63);
		bt.add(67);
		bt.display();
		bt.size();
		int n = bt.search(70);
		if(n == 0)
			System.out.println("data not found in tree!");
		else
			System.out.println("data "+n+" present in tree!");
	}

}
	