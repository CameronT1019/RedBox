package RedBox.BSTree;
    
public class BinaryTree<T extends Comparable<T>> {
    
    // Declare the root node
	private Node<T> root;
	
	
	public void insert(T data)
	{
		root = insert(root, data);
	}
	
	// We go to the appropriate node to insert our new node 
	private Node<T> insert(Node<T> root, T data)
	{
		if (root == null)
		{
			return new Node<>(data);
		}
		else if (data.compareTo(root.data)< 0)
		{
			root.left = insert(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			root.right = insert(root.right, data);
		}
		else
		{
			// Stylistically, I have this here to explicitly state that we are
			// disallowing insertion of duplicate values. This is unconventional
			// and a bit cheeky.
			;
		}

		return root;
	}
	
	
}


