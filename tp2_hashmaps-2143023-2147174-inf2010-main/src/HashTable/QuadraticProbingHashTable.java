package HashTable;

import Interface.HashTableInterface;

public class QuadraticProbingHashTable<AnyType> extends HashTable<AnyType> implements HashTableInterface<AnyType> {
    public QuadraticProbingHashTable() {
        super(DEFAULT_TABLE_SIZE);
    }
    public QuadraticProbingHashTable(int size) {
        super(size);
    }
    @Override
    public int findPos(AnyType x){
        int offset = 1;
        int currentPos = myhash( x );

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
            nbrConflicts++;
            currentPos += offset;  // Compute ith probe
            offset += 2;
            while( currentPos >= array.length )
                currentPos -= array.length;
        }
        return currentPos;
    }
}
