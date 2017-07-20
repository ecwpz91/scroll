import java.util.Stack;

/**
 * A binary search tree class that searches, inserts, and traverses a binary tree
 * composed of linked nodes using generic types that implement a comparable method. 
 * @author mike
 * @param <T> indicating any class to be stored in a BSTthat is of the same type and can
 * be compared to one of the same type 
 */

public class BST <T extends Comparable<T>> {
	private BSTNode<T> root;
	
	/**
	 * Constructs an empty BST object that initializes the instance 
	 * variables root to null.
	 */
	public BST() {
		root = null;
	}
	
	/**
	 * Constructs a BST object containing one word that initializes 
	 * the instance variable root to that contains the element passed in
	 * as a parameter.
	 */
	public BST(T element) {
		root = new BSTNode<T>(element);
	}
	
	/**
	 * Searches this BST object to determine whether or not the target element is contained
	 * within its.
	 * @param target element being searched for inside of this BST object
	 * @param p starting pointer to begin searching from recursively
	 * @return whether or not (null) the element was contained within this BST object
	 */
	private T search(T target, BSTNode<T> p) {
		if (p==null) //check if the BST isn't initialized to anything
			return null;
		if (target.compareTo(p.getData()) == 0) //compare the target value to the current
			//pointer node; if the same return the current pointer node
			return p.getData();
		if (target.compareTo(p.getData()) < 0) //search to the left of the current pointer
			//node
			return search(target, p.getLeft());
		return search(target,p.getRight()); //Search to right of the current pointer node
	}
	
	/**
	 * Searches this BST object to determine whether or not the target element is contained
	 * within its. Set to public to allow method calling outside of this class.
	 * @param target element being search for inside this BST
	 * @return whether or not (null) element was contained within this BST object
	 */
	public T search(T target) {
		return search(target, root); //calls the search method on the root node
	}
	
	/**
	 * Determines whether or not a value exists inside of this BST object. If it does not, then it
	 * is inserted (true), else wise it is not (false).
	 * @param value to be inserted into this BST object
	 * @param p starting pointer to begin searching from recursively 
	 * @return boolean to indicate whether or not the value object was inserted into this BST
	 */
	private boolean insert(T value, BSTNode<T> p) {
		int compare = value.compareTo(p.getData()); //returned compareTo() integer
		if (compare == 0)
			return false; //trying to insert a duplicate (value already exists within the tree)
		if (compare < 0) //insert to the left
			if (p.getLeft() == null) { //value does not exist within this tree
				p.setLeft(new BSTNode<T>(value));
				return true;
			} else
				return insert(value, p.getLeft()); //recursive call to the left
		else //compare greater than zero
			if(p.getRight() == null) { //value does not exist within this tree
				p.setRight(new BSTNode<T>(value));
				return true;
			} else
				return insert(value, p.getRight()); //recursive call to the right
	}
	
	/**
	 * Searches this BST object to determine whether or not the target element is contained
	 * within its. Set to public to allow method calling outside of this class.
	 * @param value to be inserted into this BST object
	 * @return boolean to indicate whether or not the value object was inserted into this BST
	 */
	public boolean insert(T value) {
		return insert(value, root); //calls the insert method on the root node
	}

	/**
	 * Traverses this BST in order and prints uses the Node's data toString() to
	 * facilitate printing.
	 * @param p starting pointer to begin traversing recursively
	 */
	private void inorder(BSTNode<T> p) {
		if (p != null) { //checks if root is null
			inorder(p.getLeft()); //recursively traverses to the left
			System.out.print(p.toString());
			inorder(p.getRight()); //recursively traverses to the right
		}
	}
	
	/**
	 * Traverses this BST in order.
	 */
	public void inorder() {
		inorder(root);
	}
	
	/*
	 * ***************************
	 * *SEE AnagramGroup COMMENTS*
	 * ***************************
	   private Stack<T> inorder(BSTNode<T> p) {
	   		if (p != null) { //checks if root is null
	   			inorder(p.getLeft()); //recursively traverses to the left
				visited.push(p.getData()); //stores the node in visited
				inorder(p.getRight()); //recursively traverses to the right
			}
			return visited;
       }
	 
	   public Stack<T> inorder() {
	   		return inorder(root);
	   }
	 */

	/**
	 * BSTNode class using generic types to enable storage of any type of object within a BST.
	 * @author mike
	 * @param <T> indicating any type to be stored in a BSTNode
	 */
	private class BSTNode<T> {
		private BSTNode<T> left, right;  //left and right to this BSTNode
		private T data; //the data being stored in this node
		
		/**
		 * Constructs an empty BSTNode object that initializes the instance 
		 * variables data, left, and right to null.
		 */
		public BSTNode() {
			data = null;
			left = right = null;
		}
		
		/**
		 * Constructs a BSTNode object that initializes the instance 
		 * variables left, right to null, and data the the passed in parameter.
		 */
		public BSTNode(T inData) {
			data = inData;
			left = right = null;
		}
		
		/**
		 * Returns the data contained in this BSTNode.
		 * @return data contained in this BSTNode
		 */
		public T getData() {
			return data;
		}
		
		/**
		 * Initializes the data in this BSTNode to the passed in parameter.
		 * @param inData value to set data to in this BSTNode
		 */
		public void setData(T inData) {
			data = inData;
		}
		
		/**
		 * Returns the BSTNode to the right of this BSTNode.
		 * @return BSTNode<T> located to the right of this BSTNode
		 */
		public BSTNode<T> getRight() {
			return right;
		}
		
		/**
		 * Initializes the node to the right of this BSTNode.
		 * @param node that is to be set to the right of this BSTNode
		 */
		public void setRight(BSTNode<T> node) {
			right = node;
		}
		
		/**
		 * Returns the BSTNode to the left of this BSTNode.
		 * @return BSTNode<T> located to the left of this BSTNode
		 */
		public BSTNode<T> getLeft() {
			return left;
		}
		
		/**
		 * Initializes the node to the left of this BSTNode.
		 * @param node that is to be set to the left of this BSTNode
		 */
		public void setLeft(BSTNode<T> node) {
			left = node;
		}
		
		/**
		 * Returns a string representation of this BSTNode's data element.
		 * @return String representation of this BSTNode's data element
		 */
		public String toString() {
			return data.toString();
		}
	}
}