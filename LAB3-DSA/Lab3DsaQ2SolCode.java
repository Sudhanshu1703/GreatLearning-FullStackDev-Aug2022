// Java code to find a pair with given sum
// in a Balanced BST
import java.io.*;
import java.util.ArrayList;

// A binary tree node
class Node {

	int data;
	Node left, right;

	Node(int val)
	{
		data = val;
		left = right = null;
	}
}

//class BinarySearchTree {
class Lab3DsaQ2SolCode {

	// Root of BST
	Node root;

	// Constructor
	//BinarySearchTree() { root = null; }
	Lab3DsaQ2SolCode() { root = null; }
	
	void insert(int key) { root = insertRec(root, key); }

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int data)
	{

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(data);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}

	boolean isPairPresent(Node root, Node temp, int target)
	{
		if (temp == null)
			return false;

		return search(root, temp, target - temp.data)
			|| isPairPresent(root, temp.left, target)
			|| isPairPresent(root, temp.right, target);
	}

	boolean search(Node root, Node temp, int k)
	{

		if (root == null)
			return false;

		Node c = root;
		boolean flag = false;
		while (c != null && flag != true) {
			if (c.data == k && temp != c) {
				flag = true;
				System.out.println("Sum = : " + c.data + " + " + temp.data + " = " + (c.data+temp.data));
				System.out.println("Pair is : (" + c.data + "," + temp.data + ")");
				return true;
			}
			else if (k < c.data)
				c = c.left;
			else
				c = c.right;
		}

		return false;
	}

	public static void main(String[] args)
	{
		//BinarySearchTree tree = new BinarySearchTree();
		Lab3DsaQ2SolCode tree = new Lab3DsaQ2SolCode();
		/*
				15
				/	 \
			10	 20
			/ \	 / \
			8 12 16 25 */
		/*
		tree.insert(15);
		tree.insert(10);
		tree.insert(20);
		tree.insert(8);
		tree.insert(12);
		tree.insert(16);
		tree.insert(25);
		*/

		/*
				40
				/	 \
			20	 60
			/ \	 / \
			10 30 50 70 */

		tree.insert(40);
		tree.insert(20);
		tree.insert(60);
		tree.insert(10);
		tree.insert(30);
		tree.insert(50);
		tree.insert(70);

		boolean test = tree.isPairPresent(tree.root, tree.root, 130);
		if (!test)
			System.out.println("No such values are found!");
	}
}
