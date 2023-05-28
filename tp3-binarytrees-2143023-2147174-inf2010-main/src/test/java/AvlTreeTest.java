import java.util.Random;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

class AVLTreeTester {
    public static void main(String[] args) {

        AvlTree<Integer> avl = new AvlTree<Integer>();
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        Integer[] toInsert = {5,4,3,2,1,9,8,7,6};
        for(int i = 0; i < toInsert.length; i++) {
            avl.add(toInsert[i]);
            bst.add(toInsert[i]);
        }

        System.out.println("Parcours préordre de BST: "); bst.printPreOrder(); System.out.println("");
        System.out.println("Parcours en ordre de BST: "); bst.printInOrder(); System.out.println("");
        System.out.println("Parcours par niveau de BST: "); bst.printPostOrder(); System.out.println("");

        System.out.println("Parcours préordre de AVL: "); avl.printPreOrder(); System.out.println("");
        System.out.println("Parcours en ordre de AVL: "); avl.printInOrder(); System.out.println("");
        System.out.println("Parcours par niveau de AVL: "); avl.printPostOrder(); System.out.println("");


        for (int j = 1; j < 101; j++) {

            AvlTree<Integer> avlTree = new AvlTree<Integer>();
            BinarySearchTree<Integer> bstTree = new BinarySearchTree<Integer>();

            int length = j;
            int[] arrayValues = new Random().ints(length, 1, 101).toArray();
            Integer[] arrayValuesInteger = Arrays.stream(arrayValues).boxed().toArray(Integer[]::new);

            Arrays.sort(arrayValuesInteger, Collections.reverseOrder());

            for (int i = 0; i < arrayValues.length; i++) {
                avlTree.add(arrayValues[i]);
                bstTree.add(arrayValues[i]);
            }

                Random random = new Random();
                int indexToFind = random.nextInt(0, length);

                bstTree.contains(arrayValues[indexToFind]);
                avlTree.contains(arrayValues[indexToFind]);

                System.out.println("Length : " + length + "\n" + "Array : " + Arrays.toString(arrayValues));

                System.out.println("ADD");
                System.out.println("AVL : " + avlTree.counter.getAdd());
                System.out.println("BST : " + bstTree.counter.getAdd() + "\n");

                System.out.println("SEARCH");
                System.out.println("AVL : " + avlTree.counter.getSearch());
                System.out.println("BST : " + bstTree.counter.getSearch() + "\n");
                System.out.println("--------------------------------------");

            }
        }
    }
