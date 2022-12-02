import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Invalid operation, data to add cannot be null.");
        }

        if (backingArray.length == size + 1) {
            resize();
        }

        //adding data
        backingArray[size+1] = data;
        size++;

        int pointer = size;
        if (size > 1) {

            //minHeap if comparison gives parent are less than children.
            while (backingArray[pointer].compareTo(backingArray[pointer/2]) < 0) {

                //do swap
                swap(pointer,pointer/2);

                //reassign pointer
                pointer=pointer/2;

                if (pointer < 2) {
                    //exit loop if reached root.
                    break;
                }
            }
        }

    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("Invalid operation. Cannot remove from empty heap.");
        }
        //data to return
        T removedData = backingArray[1];

        //swapping root with last value
        swap(1,size);
        //eliminating last value from the heap and changing size
        backingArray[size] = null;
        size--;


        int pointer = 1;
        T minorChild, parent;
        int leftChildPointer, rightChildPointer, minorChildPointer;

        //downHeaping (only applicable if size is greater than 1).
        if (size > 1) {

            while (pointer <= size/2) {
                //set the pointers for both childs
                leftChildPointer = 2 * pointer;
                rightChildPointer = 2 * pointer + 1;

                //if any of the pointers are out of bounds, set that pointer to the other child.
                if (leftChildPointer > size) {
                    leftChildPointer = rightChildPointer;
                }
                if (rightChildPointer > size) {
                    rightChildPointer = leftChildPointer;
                }

                //compare both childs and determine who is the minor and its pointer
                if (backingArray[leftChildPointer].compareTo(backingArray[rightChildPointer]) > 0) {
                    minorChild = backingArray[rightChildPointer];
                    minorChildPointer = rightChildPointer;
                } else {
                    minorChild = backingArray[leftChildPointer];
                    minorChildPointer = leftChildPointer;
                }

                //compare the minor child to its parent and swap if necessary
                parent = backingArray[pointer];
                if (parent.compareTo(minorChild) > 0) {
                    swap(pointer, minorChildPointer);
                }

                //reassign pointer
                pointer = minorChildPointer;
            }
        }

        return removedData;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Helper method: resize backing array.
     */
    private void resize() {
        T[] tempArray = backingArray;
        backingArray = (T[]) new Comparable[tempArray.length * 2];

        for (int i = 0; i < tempArray.length; i++) {
            backingArray[i]=tempArray[i];
        }
    }

    /**
     * Helper method: swap in backing array, given 2 indexes.
     */
    private void swap(int index1, int index2) {
        T temp = backingArray[index1];
        backingArray[index1] = backingArray[index2];
        backingArray[index2] = temp;
    }

    /**
     * Helper method to print MinHeap
     */
    public void printHeap() {
        System.out.print("[");
        for (int i = 0 ; i <= size ; i++) {
            System.out.print(" ");
            System.out.print(backingArray[i]);
        }
        System.out.println("]");
    }
}