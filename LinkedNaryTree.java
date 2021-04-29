import java.util.Iterator;

/**
 * This class represents the n-ary general tree, which is composed of the
 * NaryTreeNode objects
 * 
 * @author Carrie Lu (251140757)
 */
public class LinkedNaryTree<T> {
	/**
	 * root node
	 */
	private NaryTreeNode<T> root;

	/**
	 * Constructor creates an empty tree.
	 */
	public LinkedNaryTree() {
		root = null;
	}

	/**
	 * Constructor creates a tree with the specified element as its root.
	 *
	 * @param element the element that will become the root of the new tree
	 */
	public LinkedNaryTree(NaryTreeNode<T> element) {
		root = element;
	}

	/**
	 * Method that adds the specified child node to the specified parent node.
	 *
	 * @param parent a reference to the parent node
	 * @param child  a reference to the child node
	 */
	public void addNode(NaryTreeNode<T> parent, NaryTreeNode<T> child) {
		parent.addChild(child);
	}

	/**
	 * Accessor method that gets the root of the tree
	 *
	 * @return root a reference to the root node
	 */
	public NaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Accessor method that gets the data element within the root
	 *
	 * @return data element within the root
	 */
	public T getRootElement() {
		return root.getData();
	}

	/**
	 * Method that returns true if this tree is empty and false otherwise.
	 *
	 * @return true if this tree is empty
	 * @return false if this tree is not empty
	 */
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Method that returns the integer size of this tree from the specified node.
	 *
	 * @param node used to calculate the size in the tree from this node
	 * @return count the integer size of this tree
	 */
	public int size(NaryTreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < node.getNumChildren(); i++) {
			// Recursive call to increment the count as the node changes along the traversal
			// through the tree
			count += size(node.getChild(i));

		}
		return count;

	}

	/**
	 * Method that performs a recursive preorder traversal.
	 *
	 * @param node     the node to be used as the root for this traversal
	 * @param tempList the temporary list for use in this traversal
	 */
	public void preorder(NaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		if (node == null) {
			return;

		}
		tempList.addToRear(node.getData());
		for (int i = 0; i < node.getNumChildren(); i++) {
			preorder(node.getChild(i), tempList);
		}

	}

	/**
	 * Method that performs an preorder traversal on this tree by calling an
	 * overloaded, recursive preorder method that starts with the root.
	 *
	 * @return an preorder iterator over this tree
	 */
	public Iterator<T> iteratorPreorder() {
		ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
		preorder(root, templist);
		return templist.iterator();

	}

	/**
	 * Method that returns a string representation of this tree with each of the
	 * preorder elements with a newline character after each element
	 * 
	 * @return String representation of the tree
	 */
	public String toString() {
		if (isEmpty()) {
			return "Tree is empty.";

		}
		return iteratorPreorder().toString();
	}

}
