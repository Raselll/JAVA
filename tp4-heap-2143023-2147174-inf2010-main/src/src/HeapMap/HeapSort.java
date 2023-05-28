package HeapMap;
import java.util.*;
import java.util.Random;

public class HeapSort {
    // Generating random values BETWEEN 0 and 100 ==> My chosen boundary
    public static int max = 100;
    public static int min = 0;
    public static int desiredSize = 25;

    public static int[] GenerateRDArray(int size) {
        Random RD = new Random();
        // Inspired by : https://www.tutorialkart.com/java/java-random-ints/
        int[] arrayValues = new Random().ints(size, min, max).toArray();
        return arrayValues;
    }

    public static void main(String[] args) {
        Integer[] array1 = Arrays.stream(GenerateRDArray(desiredSize)).boxed().toArray(Integer[]::new);
        Integer[] array2 = Arrays.stream(GenerateRDArray(desiredSize)).boxed().toArray(Integer[]::new);
        Integer[] array3 = Arrays.stream(GenerateRDArray(desiredSize)).boxed().toArray(Integer[]::new);


        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(array1));
        Heap<Integer> HeapMap1 = new Heap<Integer>(true, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(array2));
        Heap<Integer> HeapMap2 = new Heap<Integer>(true, arr2);

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(array3));
        Heap<Integer> HeapMap3 = new Heap<Integer>(true, arr3);

        System.out.println("//// --------------------------------------------------------------------------------------------------------- ////");
        System.out.println("***Array de int aleatoires***");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));

        System.out.println("//// --------------------------------------------------------------------------------------------------------- ////");
        System.out.println("***Heap non trie***");
        HeapMap1.printArray();
        HeapMap2.printArray();
        HeapMap3.printArray();

        System.out.println("//// --------------------------------------------------------------------------------------------------------- ////");
        System.out.println("***Heap trie***");
        System.out.println("HeapMap1 : " + HeapMap1.heapsort(arr1));
        System.out.println("HeapMap2 : " + HeapMap2.heapsort(arr2));
        System.out.println("HeapMap3 : " + HeapMap3.heapsort(arr3));

        System.out.println("//// --------------------------------------------------------------------------------------------------------- ////");
    }
}
