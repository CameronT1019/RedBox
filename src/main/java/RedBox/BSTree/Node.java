// Cameron Testerman cxt200003 2021550951
package RedBox.BSTree;


public class Node<E extends Comparable<E>> {
    
    E data;      // the information to be stored in the node
    Node left = null;   // the pointer to the node's left subtree
    Node right = null;  // the pointer to the node's right subtree

    // Constructors
    Node(E data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node(E element) {
        this.data = element;
    }

    
    // Accessors
    public E getData () {
        return data;
    }

    public Node getLeft () {
        return left;
    }

    public Node getRight () {
        return right;
    }

    // Mutators
    public void setData (E newData) {
        this.data = newData;
    }

    public void setLeft (Node newLeft) {
        left = newLeft;
    }

    public void setRight(Node newRight) {
        right = newRight;
    }
    
    public int compareTo(Node<E> newNode)
    {
        int i = 0;
        i = data.compareTo(newNode.data);
        return i;
    }
    
}
