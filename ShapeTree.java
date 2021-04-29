import java.util.Iterator;

/**
 * This class represents the tree that contains Shape objects in the nodes.
 * 
 * @author Carrie Lu (251140757)
 */
public class ShapeTree {
	/**
	 * LinkedNaryTree of Shape type
	 */
	private LinkedNaryTree<Shape> tree;

	/**
	 * Accessor method that gets the tree
	 *
	 * @return tree
	 */
	public LinkedNaryTree<Shape> getTree() {
		return tree;

	}

	/**
	 * Accessor method that gets the root
	 *
	 * @return root of the tree
	 */
	public NaryTreeNode<Shape> getRoot() {
		return tree.getRoot();
	}

	/**
	 * Method that adds the new node as a child to the new node if there is a
	 * suitable place for it.
	 *
	 * @param shape parameter to be passed into addShapeNodeHelper method
	 */
	public void addShapeNode(Shape shape) {
		NaryTreeNode<Shape> node = new NaryTreeNode<Shape>(shape);

		// If the tree is empty, set the new node as the root
		if (tree == null) {
			tree = new LinkedNaryTree<>(node);

		} else {
			NaryTreeNode<Shape> parentNode = addShapeNodeHelper(shape);
			// If parentNode exists add child node to it
			if (parentNode != null) {
				parentNode.addChild(node);
			}

		}

	}

	/**
	 * Method that performs a stack-based preorder traversal on the tree and calls
	 * the checkNode method to see if the shape can be added on node v
	 *
	 * @param shape parameter to be passed into checkNode method
	 */
	public NaryTreeNode<Shape> addShapeNodeHelper(Shape shape) {
		Iterator<NaryTreeNode<Shape>> myIterator = iteratorPreorder();

		while (myIterator.hasNext()) {
			NaryTreeNode<Shape> v = myIterator.next();

			// If a node v is found in which the new shape can be added, then return the
			// node and end the function
			if (checkNode(v, shape)) {
				return v;

			}
		}
		// Otherwise, return null
		return null;

	}

	/**
	 * Method that checks the first 3 rules of the ShapeTree indicating whether or
	 * not the given shape parameter can be added on the given node parameter
	 *
	 * @param node  parent node
	 * @param shape shape to be checked in relation to the node and the ShapeTree
	 *              rules
	 * @return true if shape can be added
	 * @return false if shape cannot be added
	 */
	public boolean checkNode(NaryTreeNode<Shape> node, Shape shape) {
		// A node can have up to x children, where x is the number of lines in that
		// node's contained Shape
		if (node.getNumChildren() < node.getData().getNumSides()) {
			// A node cannot have a child whose Shape is the same colour as the node's Shape
			if (!node.getData().getColour().equals(shape.getColour())) {
				for (int i = 0; i < node.getNumChildren(); i++) {
					// There cannot be sibling nodes that contains Shapes of the same colour
					if (node.getChild(i).getData().getColour().equals(shape.getColour())) {
						return false;
					}
				}
				return true;
			}

		}
		return false;
	}

	/**
	 * Method that returns a string representation of this ShapeTree with each of
	 * the preorder elements with a newline character after each element
	 * 
	 * @return String representation of the ShapeTree
	 */
	public String toString() {
		return iteratorPreorder().toString();
	}

	/**
	 * Method that performs a recursive preorder traversal.
	 *
	 * @param node     the node to be used as the root for this traversal
	 * @param tempList the temporary list for use in this traversal
	 */
	private void preorder(NaryTreeNode<Shape> node, ArrayUnorderedList<NaryTreeNode<Shape>> tempList) {
		if (node == null) {
			return;

		}
		tempList.addToRear(node);
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
	private Iterator<NaryTreeNode<Shape>> iteratorPreorder() {
		ArrayUnorderedList<NaryTreeNode<Shape>> templist = new ArrayUnorderedList<NaryTreeNode<Shape>>();
		preorder(tree.getRoot(), templist);
		return templist.iterator();

	}

}
