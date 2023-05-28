package HeapMap;
import javax.swing.*;
import java.nio.BufferUnderflowException;
import java.util.*;

public class Heap<AnyType extends Comparable<? super AnyType>>
{

    private static final boolean DEFAULT_IS_MAX_HEAP = true;
    private static final int DEFAULT_CAPACITY = 10;
    private boolean isMaxHeap;
    private int currentSize;          // Number of elements in heap
    private ArrayList<AnyType> array; // The heap array

    /**
     * Construct the binary heap max or min.
     * @param isMaxHeapParam is true if we want a max heap and false if we want a min heap
     */
    public Heap(boolean isMaxHeapParam) {
        this.isMaxHeap = isMaxHeapParam;
        this.array = new ArrayList<>();
    }

    /**
     * Construct the binary heap, is max by default.
     */
    public Heap( )
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct the binary heap, is max by default.
     * @param capacity the capacity of the binary heap.
     */
    public Heap( int capacity )
    {
        this.isMaxHeap = DEFAULT_IS_MAX_HEAP;
        this.currentSize = 0;
        this.array = new ArrayList<AnyType>(capacity + 1);
    }

    /**
     * Construct the binary heap, is max by default.
     * @param items the array of items to buid the tree with.
     */
    public Heap( ArrayList<AnyType> items )
    {
        this.isMaxHeap = DEFAULT_IS_MAX_HEAP;
        currentSize = items.size();
        array = items;
        heapify( );
    }

    /**
     * Construct the binary heap, is max by default.
     * @param items the array of items to buid the tree with.
     * @param isMaxHeapParam is true if we want a max heap and false if we want a min heap.
     */
    public Heap( boolean isMaxHeapParam, ArrayList<AnyType> items )
    {
        this.isMaxHeap = isMaxHeapParam;
        currentSize = items.size();
        this.array = items;
        heapify();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( AnyType x ) {
        if (currentSize == array.size() - 1)
            enlargeArray(array.size() * 2 + 1);

        int hole = ++currentSize;

        if (this.isMaxHeap)
        {
            for (array.set(0, x); x.compareTo(array.get(hole / 2)) > 0; hole /= 2)
                array.set(hole, array.get(hole / 2));
            array.set(hole, x);

        }
        else
        {
            for (array.set(0, x); x.compareTo(array.get(hole / 2)) < 0; hole /= 2)
                array.set(hole, array.get(hole / 2));
            array.set(hole, x);
        }

    }

    /**
     * Find the smallest item in the priority queue.
     * @return the first item in the array. Is the max if max heap, is the min if min heap (depending on the value of isMaxHeap),
     * or throw an UnderflowException if empty.
     */
    public AnyType peek( )
    {
        if (isEmpty())
            throw new BufferUnderflowException();
        return array.get(1);
    }

    /**
     * Remove the smallest/biggest item from the priority queue.
     * @return the smallest/biggest item, or throw UnderflowException, if empty.
     */
    public AnyType deleteFirst( )
    {
        if( isEmpty( ) )
            throw new BufferUnderflowException();

        AnyType firstItem = peek( );
        array.set(1, array.get(currentSize--));
        percolateDown( 1 );

        return firstItem;
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty()
    {
        currentSize = 0;
        for (int i = 0; i < array.size(); i++)
            array.set(i, null);
    }

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole )
    {
        int child;
        AnyType temp = array.get(hole);

        if (this.isMaxHeap) {
            for (; hole * 2 <= currentSize; hole = child) {
                child = hole * 2;
                if (child != currentSize - 1 && array.get(child + 1).compareTo(array.get(child)) > 0)
                    child++;
                if (array.get(child).compareTo(temp) > 0)
                    array.set(hole, array.get(child));
                else
                    break;
            }
            array.set(hole, temp);
        }
        else
        {
            for (; hole * 2 <= currentSize; hole = child) {
                child = hole * 2;
                if (child != currentSize - 1 && array.get(child + 1).compareTo(array.get(child)) < 0)
                    child++;
                if (array.get(child).compareTo(temp) < 0)
                    array.set(hole, array.get(child));
                else
                    break;
            }
            array.set(hole, temp);
        }
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void heapify()
    {
        {
            for( int i = currentSize / 2; i >= 0; i-- )
                percolateDown( i );
        }
    }

    /**
     * Method to create a new enlarged/bigger array
     * @param newSize the size of the new array
     */
    private void enlargeArray(int newSize)
    {
        ArrayList<AnyType> old = array;
        array = new ArrayList<AnyType>(newSize);
        for( int i = 0; i < old.size(); i++ )
            array.set(i, old.get(i));
    }

    /**
     * Method to swap two items in a given array
     * @param a the array in question
     * @param firstIndex index of the first item to swap
     * @param secondIndex index of the second item to swap
     */
    private void swapReferences(ArrayList<AnyType> a, int firstIndex, int secondIndex) {
        AnyType tmp = a.get(firstIndex);
        a.set(firstIndex, a.get(secondIndex));
        a.set(secondIndex, tmp);
    }

    /**
     * Internal method for heapsort
     * @param a: un tableau dont les éléments sont de type Comparable.
     * @int i: la position de l’élément à percoler.
     * @int n: la position après le dernier élément du monceau.
     */
    private void percDown(ArrayList<AnyType> a, int i, int n) {
        int child;
        AnyType tmp;
        for(tmp = a.get(i); leftChild( i ) < n; i = child) {
            child = leftChild(i);
            if(child != n - 1 && a.get(child).compareTo(a.get(child+1)) < 0)
                child++;
            if(tmp.compareTo( a.get(child)) < 0)
                a.set(i,a.get(child));
            else
                break;
        }
        a.set(i, tmp);
    }

    /**
     * Standard heapsort.
     * @param a an array of Comparable items.
     */
    public ArrayList<AnyType> heapsort(ArrayList<AnyType> a) {
        for(int i = a.size() / 2; i >= 0; i--)      /* construire le monceau */
            percDown(a, i, a.size());
        for(int i = a.size() - 1; i > 0; i--) {
            swapReferences(a, 0, i);        /* permuter le maximum (racine) et dernière élément du monceau */
            percDown(a, 0, i);
        }
        return a;
    }

    /**
     * Simple method to find the index of the left child giving an item
     * @param i item we want to find the left child of
     * @return the index of the left child
     */
    private static int leftChild(int i)
    {
        return 2 * i + 1;
    }

    /**
     * Simple method to output the arrray for test purposes.
     */
    public void printArray(){
        System.out.println(Arrays.deepToString(array.toArray()));
    }

}

