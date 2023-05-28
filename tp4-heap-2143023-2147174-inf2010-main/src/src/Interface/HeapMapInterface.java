package Interface;

import java.util.ArrayList;

public interface HeapMapInterface<AnyType> {
    void insert( AnyType x );
    boolean isMaxHeap();
    public AnyType peek();
    public AnyType deleteMin();
    boolean isEmpty();
    void makeEmpty();
    void percolateDown(int hole);
    void heapify();
    void enlargeArray(int newSize);
    void swapReferences(ArrayList<AnyType> a, int firstIndex, int secondIndex);
    void percDown(ArrayList<AnyType> a, int i, int n);
    int leftChild(int i);
    ArrayList<AnyType> heapsort(ArrayList<AnyType> a);


}
