import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Please add a valid input to add to the tree.");
        }
        this.root = recursiveAdd(this.root, data);
    }

    private BSTNode<T> recursiveAdd(BSTNode<T> current, T data) {

        if (current == null) {
            size++;
            //System.out.println("Entered base case: Size increased to " + size + " and returning node with data= " + data);
            return new BSTNode<>(data);
        }
        else if (data.compareTo(current.getData())<0) {
            //System.out.println("Entered left condition, making recursive call with data= " + data + " current node's data is = " + current.getData());
            current.setLeft(recursiveAdd(current.getLeft(), data));
        }
        else if (data.compareTo(current.getData())>0) {
            //System.out.println("Entered right condition, making recursive call with data= " + data + " current node's data is = " + current.getData());
            current.setRight(recursiveAdd(current.getRight(), data));
        }
        //System.out.println("Returning current (pointer reinforcement) with data= " + current.getData());
        return current;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Please enter a valid input to remove from the tree.");
        }

        BSTNode<T> dummyNode = new BSTNode<>(null);
        this.root = recursiveRemove(this.root, data, dummyNode);

        return dummyNode.getData();
    }

    private BSTNode<T> recursiveRemove(BSTNode<T> current, T data, BSTNode<T> dummy) {

        if (current == null) {
            //data not found
            throw new NoSuchElementException("Data not found in tree.");
        }
        else if (data.compareTo(current.getData())<0) {
            //continue traversal to the left
            //System.out.println("Entered left condition, making recursive call with data= " + data + " current node's data is = " + current.getData());
            current.setLeft(recursiveRemove(current.getLeft(), data, dummy));
        }
        else if (data.compareTo(current.getData())>0) {
            //continue traversal to the right
            //System.out.println("Entered right condition, making recursive call with data= " + data + " current node's data is = " + current.getData());
            current.setRight(recursiveRemove(current.getRight(), data, dummy));
        }
        else {
            //data found
            dummy.setData(current.getData());
            size--;
            //System.out.println("Entered data found case, size decreased and it is now: " + size + " current node's data is = " + current.getData());

            //base case if no children
            if (current.getLeft() == null && current.getRight() == null) {
                //System.out.println("No child case entered, current data is: " + current.getData());
                return null;
            }
            //return left child if exists
            else if (current.getLeft() != null && current.getRight() == null) {
                //System.out.println("Left child only case entered, current data is: " + current.getData());
                return current.getLeft();
            }
            //return right child if exists
            else if (current.getRight() != null && current.getLeft() == null) {
                //System.out.println("Right child only case entered, current data is: " + current.getData());
                return current.getRight();
            }
            //if the node has two children
            else {
                //System.out.println("Two children case entered, calling the recursive successor method, current data is " + current.getData());
                BSTNode<T> dummy2 = new BSTNode<>(null);
                current.setRight(getRecursiveSuccessor(current.getRight(), dummy2));
                current.setData(dummy2.getData());
            }

        }

        System.out.println("Returning current (pointer reinforcement) with data= " + current.getData());
        return current;
    }


    private BSTNode<T> getRecursiveSuccessor(BSTNode<T> current, BSTNode<T> dummy) {
        //System.out.println("Getting recursive successor, current data is: " + current.getData());
        if (current.getLeft()==null) {
            //System.out.println("Entered no left child condition in recursive successor, returning data from the right and it is: " + current.getData());
            dummy.setData(current.getData());
            return current.getRight();
        }
        else {
            //System.out.println("Still has left child, calling again recursive successor, current data is " + current.getData());
            current.setLeft(getRecursiveSuccessor(current.getLeft(),dummy));
            //System.out.println("Reinforcing pointer in recursive successor method, current data is " + current.getData());
            return current;
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}