package HashTable;

import Interface.HashTableInterface;

public class DoubleHashTable<AnyType> extends HashTable<AnyType> implements HashTableInterface<AnyType> {
    public DoubleHashTable() {
        super(DEFAULT_TABLE_SIZE);
    }
    public DoubleHashTable(int size) {
        super(size);
    }
    @Override
    public int findPos(AnyType x){
        int currentPos = myhash( x );
        int offset = myhash2(x);

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
            nbrConflicts++;
            currentPos += offset;
            while ( currentPos >= array.length ) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

}
