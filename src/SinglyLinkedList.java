import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Invalid argument. Error when adding to Linked List.");
        }

        if (size == 0) {
            SinglyLinkedListNode<T> current = new SinglyLinkedListNode<>(data);
            head = current;
            tail = current;
        }
        else {
            SinglyLinkedListNode<T> current = new SinglyLinkedListNode<>(data,head);
            head = current;
        }
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Invalid argument. Error when adding to Linked List.");
        }

        SinglyLinkedListNode<T> current = new SinglyLinkedListNode<>(data);

        if (size == 0) {
            head = current;
            tail = current;
        }
        else {
            tail.setNext(current);
            tail = current;
        }
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("Error removing from Linked List: List is empty.");
        }

        SinglyLinkedListNode<T> removed = head;

        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            head = removed.getNext();
        }
        size--;
        return removed.getData();
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("Error removing from Linked List: List is empty.");
        }

        SinglyLinkedListNode<T> removed = tail;
        SinglyLinkedListNode<T> current = head;
        SinglyLinkedListNode<T> temp = current;

        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
                while (current.getNext() != null) {
                    temp = current;
                    current = current.getNext();
                }
            tail = temp;
            tail.setNext(null);
        }

        size--;
        return removed.getData();
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /* End of EDX submission */

    public void print() {
        System.out.print("[");
        SinglyLinkedListNode<T> current = head;
        while (current != null) {
            System.out.print(" " + current.getData());
            current = current.getNext();
        }
        if (head != null || tail != null) {
            System.out.println(" " + "] and size is " + size + ". Head is " + head.getData() + " and Tail is " + tail.getData());
        }
        else {
            System.out.println(" " + "] and size is " + size);
        }

    }
}