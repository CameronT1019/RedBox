package RedBox.BSTree;


public class BinaryTree<E extends Comparable<E>> {
    
   private Node<E> root;

   public BinaryTree () {
      root = null;
   }
   
   public void insert(E data) {
       root = insert(root, data);
   }
   
   private Node<E> insert(Node<E> currentRoot, E data) {

       // instantiate a new Node with data as data if the current root has not been previously instantiated
       if (currentRoot == null) {
           return new Node<E>(data);
       }
       // if the value of the data being searched for is less than the value of the current root node, then 
       // traverse to the left node of the current root, setting the current left node to whatever gets returned
       // from the insert method
       else if (data.compareTo(currentRoot.data) < 0) {
           root.left = insert(currentRoot.left, data);
       }
       // if the value of the data being searched for is less than the value of the current root node, then 
       // traverse to the right node of the current root, setting the current right node to whatever gets returned
       // from the insert method
       else if (data.compareTo(currentRoot.data) > 0) {
           root.right = insert(root.right, data);
       } else {
           // Stylistically, I have this here to explicitly state that we are
           // disallowing insertion of duplicate values.
           ;
       }
       return root;
   }
   
   public E search(E data) {
       return searchHelper(root, data);
   }

   private E searchHelper(Node<E> currentNode, E newData) {
       if (currentNode == null) {
           return null;
       }
       if (currentNode.data.compareTo(newData) == 0) {
           return (E) currentNode;
       } else if (currentNode.data.compareTo(newData) < 0) {
           return searchHelper(currentNode.right, newData);
       } else {
           return searchHelper(currentNode.left, newData);
       }

   }
   
   public boolean delete(E data) {
       return deleteHelper(null, root, data);
   }
    
   private boolean deleteHelper(Node<E> parent, Node<E> currentNode, E newData) {
       if (currentNode == null) {
           return false;
       }
       if (currentNode.data.compareTo(newData) == 0) {
           if (currentNode.equals(root) && root.getLeft() == null && root.getRight() == null) {
               root = null;
               return true;
           }
           leftShifter(parent, currentNode);
           return true;
       }
       else if (currentNode.data.compareTo(newData) < 0) {
           return deleteHelper(currentNode, currentNode.getRight(), newData);
       }
       else {
           return deleteHelper(currentNode, currentNode.getLeft(), newData);
       }
   }

        
   private void leftShifter(Node<E> parent, Node<E> currentNode) {
       if (currentNode == null) {
           return;
       }
        
       if (currentNode.getLeft() == null) {
           if (parent.getLeft() == null) {
               parent.setLeft(null);
           } else {
               parent.setRight(null);
           }
           return;
       }
       
       currentNode = currentNode.getLeft().clone();

       if (currentNode.getLeft().getLeft() == null) {
           currentNode.setLeft(null);
           return;
       }
       leftShifter(currentNode, currentNode.getLeft());
    }
}


