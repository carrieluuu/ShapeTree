/**
 * This class represents a single node in an n-ary (general) tree.
 * 
 * @author Carrie Lu (251140757)
 */

public class NaryTreeNode<T> {
	/**
	 * Generic type data item
	 */
	private T data;
	/**
	 * Number of children a node has
	 */
	private int numChildren;
	/**
	 * NaryTreeNode<T> type array storing the children nodes
	 */
	private NaryTreeNode<T>[] children;

	/**
	 * Constructor creates a new tree node with the specified data.
	 *
	 * @param data the element that will become a part of the new tree node
	 */
	public NaryTreeNode(T data) {
		this.data = data;
		this.children = null;
	}

	/**
	 * Method that adds the specified child node to the node
	 *
	 * @param newChild Child node to be added to this node
	 */
	public void addChild(NaryTreeNode<T> newChild) {
		// If children is currently null, initialize it with 3 slots
		if (children == null) {
			children = (NaryTreeNode<T>[]) (new NaryTreeNode[3]);

		}
		// If the children array is full, call expandCapacity
		else if (numChildren % 3 == 0) {
			expandCapacity();
		}
		// Add newChild to the next available slot in the children array
		children[numChildren] = newChild;
		numChildren++;

	}

	/**
	 * Method that creates a new, larger array to store the contents of children
	 * array with an increased capacity of 3 spots
	 */
	public void expandCapacity() {
		NaryTreeNode<T>[] larger = (NaryTreeNode<T>[]) (new NaryTreeNode[numChildren + 3]);
		for (int i = 0; i < numChildren; i++) {
			larger[i] = children[i];
		}
		children = larger;

	}

	/**
	 * Accessor method that gets the number of children the node has
	 *
	 * @return numChildren number of children
	 */
	public int getNumChildren() {
		return numChildren;

	}

	/**
	 * Accessor method that gets the child stored in the given index
	 *
	 * @param index index of the child in the children array
	 * @return numChildren child node
	 */
	public NaryTreeNode<T> getChild(int index) {
		return children[index];
	}

	/**
	 * Accessor method that gets the data item stored in the node
	 *
	 * @return data item stored in the node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Method that returns a string representation of this node that says "Node
	 * containing " followed by the data item stored
	 * 
	 * @return result formatted String representation of the queue
	 */
	public String toString() {
		String str = "Node containing ";
		str += data;
		return str;
	}
}
