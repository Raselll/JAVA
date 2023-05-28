package Interface;

public interface HashTableInterface <AnyType> {
    void insert(AnyType x);
    void rehash();
    int findPos(AnyType x);
    void remove(AnyType x);
    boolean contains(AnyType x);
    boolean isActive(int currentPos);
    void makeEmpty();
    int myhash(AnyType x);
}
