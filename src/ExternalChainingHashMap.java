import java.util.NoSuchElementException;

/**
 * Your implementation of a ExternalChainingHashMap.
 */
public class ExternalChainingHashMap<K, V> {

    /*
     * The initial capacity of the ExternalChainingHashMap when created with the
     * default constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * The max load factor of the ExternalChainingHashMap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final double MAX_LOAD_FACTOR = 0.67;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private ExternalChainingMapEntry<K, V>[] table;
    private int size;

    /**
     * Constructs a new ExternalChainingHashMap with an initial capacity of INITIAL_CAPACITY.
     */
    public ExternalChainingHashMap() {
        //DO NOT MODIFY THIS METHOD!
        table = (ExternalChainingMapEntry<K, V>[]) new ExternalChainingMapEntry[INITIAL_CAPACITY];
    }

    /**
     * Adds the given key-value pair to the map. If an entry in the map
     * already has this key, replace the entry's value with the new one
     * passed in.
     *
     * In the case of a collision, use external chaining as your resolution
     * strategy. Add new entries to the front of an existing chain, but don't
     * forget to check the entire chain for duplicate keys first.
     *
     * If you find a duplicate key, then replace the entry's value with the new
     * one passed in. When replacing the old value, replace it at that position
     * in the chain, not by creating a new entry and adding it to the front.
     *
     * Before actually adding any data to the HashMap, you should check to
     * see if the table would violate the max load factor if the data was
     * added. Resize if the load factor (LF) is greater than max LF (it is
     * okay if the load factor is equal to max LF). For example, let's say
     * the table is of length 5 and the current size is 3 (LF = 0.6). For
     * this example, assume that no elements are removed in between steps.
     * If another entry is attempted to be added, before doing anything else,
     * you should check whether (3 + 1) / 5 = 0.8 is larger than the max LF.
     * It is, so you would trigger a resize before you even attempt to add
     * the data or figure out if it's a duplicate. Be careful to consider the
     * differences between integer and double division when calculating load
     * factor.
     *
     * When regrowing, resize the length of the backing table to
     * (2 * old length) + 1. You should use the resizeBackingTable method to do so.
     *
     * @param key   The key to add.
     * @param value The value to add.
     * @return null if the key was not already in the map. If it was in the
     *         map, return the old value associated with it.
     * @throws java.lang.IllegalArgumentException If key or value is null.
     */
    public V put(K key, V value) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        if (key == null || value == null) {
            throw new IllegalArgumentException("The key or the value is null, please enter the right arguments.");
        }

        int currentCapacity = table.length;
        double newLoadFactor = (size + 1)/(double)currentCapacity;

        if (newLoadFactor > MAX_LOAD_FACTOR) {
            resizeBackingTable(2*currentCapacity + 1);
        }

        int position = Math.abs(key.hashCode() % table.length);

        //Case when nothing is in the table at the position
        if (table[position] == null) {
            table[position] = new ExternalChainingMapEntry<>(key, value);
            size++;
            return null;
        }
        //If there is an entry in the table
        else {

            V valueToReturn;
            ExternalChainingMapEntry<K, V> currentEntry = table[position];

            //Case if only one entry at the position
            if (currentEntry.getNext()==null) {
                    //case if keys match
                    if (key.equals(table[position].getKey())) {
                        valueToReturn = table[position].getValue();
                        table[position].setValue(value);
                    }
                    // if keys don't match
                    else {
                        valueToReturn = null;
                        table[position] = new ExternalChainingMapEntry<>(key, value, table[position]);
                        size++;
                    }
                    return valueToReturn;
                }
            //Case if more than one entry
            else {
                //iterate through all entries at the position
                while (currentEntry != null) {
                    if (key.equals(currentEntry.getKey())) {
                        valueToReturn = currentEntry.getValue();
                        currentEntry.setValue(value);
                        return valueToReturn;
                    }
                    currentEntry = currentEntry.getNext();
                }
                table[position] = new ExternalChainingMapEntry<>(key, value, table[position]);
                size++;
                return null;
            }
        }
    }

    /**
     * Removes the entry with a matching key from the map.
     *
     * @param key The key to remove.
     * @return The value associated with the key.
     * @throws java.lang.IllegalArgumentException If key is null.
     * @throws java.util.NoSuchElementException   If the key is not in the map.
     */
    public V remove(K key) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (key == null ) {
            throw new IllegalArgumentException("Null argument. Please enter the correct argument.");
        }

        V valueToReturn = null;
        int position = Math.abs(key.hashCode() % table.length);

        //throw exception if nothing is entered in the table
        if (table[position]==null) {
            throw new NoSuchElementException("The key entered is not in the map.");
        }

        //Case if only one entry in the position
        if (table[position].getNext()==null && key.equals(table[position].getKey())) {
            valueToReturn = table[position].getValue();
            table[position] = null;
            size--;
            return valueToReturn;
        }

        //flag to throw exception if key not in the table
        boolean deleted = false;

        //Case if multiple entries are in the position
        if (table[position].getNext() != null) {

            //Case if it is the head
            if (key.equals(table[position].getKey())) {
                valueToReturn = table[position].getValue();
                table[position] = table[position].getNext();
                size--;
                return valueToReturn;
            }

            //Case if it is not the head
            else {
                //Iteration through the list
                ExternalChainingMapEntry<K, V> current = table[position];
                while (current!=null){

                    //Case if we're on the tail
                    if (current.getNext() == null) {
                        if (key.equals(current.getKey())) {
                            valueToReturn = current.getValue();
                            current = null;
                            deleted = true;
                            size--;
                        }
                    }
                    //Case if we're not on the tail
                    else {
                        if (key.equals(current.getNext().getKey())) {
                            valueToReturn = current.getNext().getValue();
                            current.setNext(current.getNext().getNext());
                            deleted = true;
                            size--;
                        }
                    }

                    current = current.getNext();
                }
            }
        }

        if (!deleted) {
            throw new NoSuchElementException("The key entered is not in the map.");
        }

        return valueToReturn;
    }

    /**
     * Helper method stub for resizing the backing table to length.
     *
     * This method should be called in put() if the backing table needs to
     * be resized.
     *
     * You should iterate over the old table in order of increasing index and
     * add entries to the new table in the order in which they are traversed.
     *
     * Since resizing the backing table is working with the non-duplicate
     * data already in the table, you won't need to explicitly check for
     * duplicates.
     *
     * Hint: You cannot just simply copy the entries over to the new table.
     *
     * @param length The new length of the backing table.
     */
    private void resizeBackingTable(int length) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        ExternalChainingMapEntry<K, V>[] tempTable = (ExternalChainingMapEntry<K, V>[]) new ExternalChainingMapEntry[length];

        int position;
        ExternalChainingMapEntry<K,V> tempEntry;
        ExternalChainingMapEntry<K, V> tempSwap;
        ExternalChainingMapEntry<K,V> current;

        for (int i = 0 ; i < table.length ; i++) {

            if (table[i]!=null) {

                position = Math.abs(table[i].getKey().hashCode() % length);
                tempEntry = table[i];

                //case if only a single element to add to new table
                if (tempEntry.getNext()==null) {

                    //check if tempTable is empty
                    if (tempTable[position] != null) {
                        tempSwap = tempTable[position];
                        tempEntry.setNext(tempSwap);
                    }
                    tempTable[position] = tempEntry;
                }

                else {
                    //iterating through elements in list
                    current = tempEntry;
                    while (current!=null) {
                        position = Math.abs(current.getKey().hashCode() % length);
                        if (tempTable[position] != null) {
                            tempSwap = tempTable[position];
                            tempEntry = new ExternalChainingMapEntry<>(current.getKey(), current.getValue());
                            tempEntry.setNext(tempSwap);
                        }
                        tempTable[position] = new ExternalChainingMapEntry<>(current.getKey(), current.getValue());
                        current = current.getNext();

                    }
                }
            }
        }
        table = tempTable;
    }

    /**
     * Returns the table of the map.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The table of the map.
     */
    public ExternalChainingMapEntry<K, V>[] getTable() {
        // DO NOT MODIFY THIS METHOD!
        return table;
    }

    /**
     * Returns the size of the map.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the map.
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public void print() {
        // HELPER METHOD TO PRINT AND VISUALIZE TABLE, DO NOT SUBMIT TO edX.
        System.out.print("{");
        for (int i = 0 ; i< table.length ; i++) {
            System.out.print("[");
            if (table[i]!=null) {
                System.out.print(" " + table[i].getKey() + "," + table[i].getValue()+ " ");
                ExternalChainingMapEntry<K,V> nextEntry = table[i].getNext();
                while (nextEntry!=null) {
                    System.out.print(" " + nextEntry.getKey() + "," + nextEntry.getValue() + " ");
                    nextEntry = nextEntry.getNext();
                }
            }
            System.out.print("]; ");
        }
        System.out.println("}");
    }
}