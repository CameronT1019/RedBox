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
	
	public boolean search(T toSearch)
   {
       return search(root, toSearch);
   }
   
   private boolean search(Node<T> p, T toSearch)
   {
      if (p == null)
         return false;
      else
      if (toSearch.compareTo(p.data) == 0)
      	return true;
      else
      if (toSearch.compareTo(p.data) < 0)
         return search(p.left, toSearch);
      else
         return search(p.right, toSearch);
   }
	
	public void delete(T toDelete)
   {
       root = delete(root, toDelete);
   }
    
   private Node<T> delete(Node<T> p, T toDelete)
   {
      if (p == null)
         throw new RuntimeException("cannot delete.");
      else if (toDelete.compareTo(p.data) < 0)
         p.left = delete(p.left, toDelete);
      else if (toDelete.compareTo(p.data) > 0)
         p.right = delete(p.right, toDelete);
      else {
         if (p.left == null)
            return p.right;
         else if (p.right == null)
            return p.left;
         else {
            // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.left);
            // delete the rightmost node in the left subtree
            p.left = delete(p.left, p.data);
         }
      }
      return p;
   }
    
   private T retrieveData(Node<T> p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }
	
	
}


