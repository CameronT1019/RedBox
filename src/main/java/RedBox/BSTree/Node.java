package RedBox.BSTree;

import RedBox.Movies.Movie;

public class Node<E extends Comparable<E>> {
    
    protected E data;      // the information to be stored in the node
    protected Node<E> left;   // the pointer to the node's left subtree
    protected Node<E> right;  // the pointer to the node's right subtree

    // Constructors
    public Node() {
        left = null;
        right = null;
    }

    Node(E element) {
        this.data = element;
        this.left = null;
        this.right = null;
    }

    // Overloaded Constructor
    /* public Node (String title, Integer available, Integer rented) {
        data = new Movie<>(title, available, rented);
        left = null;
        right = null;
    }  */
    
    // Accessors
    public E getData () {
        return data;
    }

    public Node<E> getLeft () {
        return left;
    }

    public Node<E> getRight () {
        return right;
    }

    // Mutators
    public void setData (E newData) {
        this.data = newData;
    }

    public void setLeft (Node<E> newLeft) {
        left = newLeft;
    }

    public void setRight(Node<E> newRight) {
        right = newRight;
    }
    
    
}
