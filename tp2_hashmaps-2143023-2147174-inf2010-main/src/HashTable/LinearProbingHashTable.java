package HashTable;

import Interface.HashTableInterface;

public class LinearProbingHashTable<AnyType> extends HashTable<AnyType> implements HashTableInterface<AnyType> {
    public LinearProbingHashTable() {
        super(DEFAULT_TABLE_SIZE);
    }
    public LinearProbingHashTable(int size) {
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
            currentPos += offset;

            if( currentPos >= array.length )
                currentPos -= array.length;
        }
        return currentPos;
    }
}
