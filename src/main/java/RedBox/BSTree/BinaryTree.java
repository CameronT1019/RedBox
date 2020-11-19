package RedBox.BSTree;
    
public class BinaryTree<T extends Comparable<T>> {
    
    // Declare the root node
	private Node<T> root;
	
	
	public void insert(T data)
	{
		root = insert(root, data);
	}
	
	// We go to the appropriate node to insert our new node 
	private Node<T> insert(Node<T> p, T data)
	{
		if (p == null)
			return new Node<T>(data);
		
		if (data.compareTo(p.data) == 0) 
			return p;
		
		if (data.compareTo(p.data) < 0)
			p.left = insert(p.left, data);
		else
			p.right = insert(p.right, data);
		
		return p;
	}
	
	public void delete(T data)
	{
		root = delete(root, data);
	}
	// We need to iterate to the right node to be deleted
	private Node<T> delete(Node<T> root, T data)
	{
		if (root == null) {
			return null;
		} else if (data.compareTo(root.data) < 0) {
			root.left = delete(root.left, data);
		} else if (data.compareTo(root.data) > 0) {
			root.right = delete(root.right, data);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			} else {
				root.data = findMax(root.left);
				root.left = delete(root.left, root.data);
			}
		}

		return root;
	}
	
	private T findMax(Node<T> root)
	{
		while (root.right != null) {
			root = root.right;
		}

		return root.data;
	}
	
	public boolean contains(T data)
	{
		return contains(root, data);
	}
	// We iterate to the right location and if the if statements dont run 
	// we know the node we are at is the right node
	private boolean contains(Node<T> root, T data)
	{
		if (root == null)
		{
			return false;
		}
		else if (data.compareTo(root.data) < 0)
		{
			return contains(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			return contains(root.right, data);
		}
		else
		{
			return true;
		}
	}
	
}


