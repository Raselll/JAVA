package HashTable;

public class HashEntry<AnyType>
{
    public AnyType  element;   // the element
    public boolean isActive;  // false if marked deleted

    public HashEntry( AnyType e )
    {
        this( e, true );
    }

    public HashEntry( AnyType e, boolean i )
    {
        element  = e;
        isActive = i;
    }
}
