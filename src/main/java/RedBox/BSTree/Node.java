package RedBox.BSTree;

public class Node<T extends Comparable<T>>{
	

	T data;
	Node<T> left, right;

	Node(T data)
	{
		this.data = data;
	}


    // *** methods ***

    // accessors (access to fields)
    public T getElement() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }
    
    public Node<T> getRight() {
        return right;
    }
    
    // mutators (change fields)
    public void setElement(T newT) {
        data = newT;
    }

    public void setLeft(Node<T> newL) {
        left = newL;
    }

    public void setRight(Node<T> newR) {
        right = newR;
    }
}

