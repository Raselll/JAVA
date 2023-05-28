import java.util.Currency;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T>{
    @Override
    public void add(T value) {
        this.root = add(value, this.root);
    }

    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {
        counter.incrementAdd();
        //TODO
        curNode = super.add(value, curNode);
        return balance(curNode);
    }

    @Override
    public void remove(T value) {
        this.root = remove(value, this.root);
    }

    protected BinaryNode<T> remove(T value, BinaryNode<T> curNode) {
        //TODO
        curNode = super.remove(value, curNode);
        return balance(curNode);
    }

   //TODO Ajouter les méthodes manquantes

    private static final int ALLOWED_IMBALANCE = 1;
    private BinaryNode<T> balance(BinaryNode<T> curNode){
//        counter.incrementAdd();
        if (curNode == null){
            return curNode;
        }
        if (height(curNode.left) - height(curNode.right) > ALLOWED_IMBALANCE){
            if (height(curNode.left.left) >= height(curNode.left.right)){
                curNode = rotateWithLeftChild(curNode);
            }
            else {
                curNode = doubleWithLeftChild( curNode );
            }
        }
        else if ( height( curNode.right ) - height( curNode.left ) > ALLOWED_IMBALANCE){
            if( height( curNode.right.right ) >= height( curNode.right.left ) ){
                curNode = rotateWithRightChild( curNode );
            }
            else {
                curNode = doubleWithRightChild( curNode );
            }
        }
        curNode.height =  Math.max( height( curNode.left ), height( curNode.right ) ) + 1;
        return curNode;
    }

    private BinaryNode<T> rotateWithLeftChild( BinaryNode<T> k2 ){
//        counter.incrementAdd();
        BinaryNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = Math.max( height( k1.left ), k2.height ) + 1;
        return k1;
    }
    private BinaryNode<T> doubleWithLeftChild( BinaryNode<T> k3 ){
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }

    private BinaryNode<T> rotateWithRightChild( BinaryNode<T> k1 ){
//        counter.incrementAdd();
        BinaryNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right),k1.height ) + 1;
        return k2;
    }

    private BinaryNode<T> doubleWithRightChild( BinaryNode<T> k1 ){
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private int height(BinaryNode<T> curNode){
        return curNode == null ? -1 : curNode.height;
    }


}
