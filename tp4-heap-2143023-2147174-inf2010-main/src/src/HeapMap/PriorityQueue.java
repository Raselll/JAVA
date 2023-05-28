package HeapMap;
import javax.management.openmbean.ArrayType;
import javax.security.auth.login.AccountException;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.Stream;

public class PriorityQueue {
    public PriorityQueue(){};

    //https://themightyprogrammer.dev/snippet/frequency-map-java
    <T> Map<T, Long>  frequencyMap(Stream<T> elements) {
        return elements.collect(
                Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new, // can be skipped
                        Collectors.counting()
                )
        );
    }
    ///************************************************************************************************************************///
    // La fonction du bas, soit celle qui est commente ne marche pas, car on a pas eu le temps de la regler. Initialement,
    // nous avons compris qu'il fallait trier l'array et retourner la valeur de l'index la plus grande a la position k
    // et NON celui qui est le plus repetee. Suite au message de Marc Assef sur Discord, nous avons arrete de faire,
    // le code du bas, qui etait sense retourne la valeur de K le plus repete. Du coup, ce message est la juste pour rappeler
    // le correcteur, que le code du trie du Integer, soit celle qui doit retourner la valeur la plus grande a la position K
    // est fesable et c'est ce dont nous avons garder pour ce TD. Marc Assef a donne sa permision sur Discord << ... je vais
    // prendre en compte les 2 versions, mais seulement pour ca . >> ==> Reference au premier bloc de code de la partie 3, soit
    // celle du trie des Integers.
    ///************************************************************************************************************************///
//    public Integer findK(ArrayList<Integer> nums, int k){
//        ArrayList<Long> frequency = new ArrayList<Long>();
//        Map<Long, Long> map = frequencyMap(frequency.stream());
//
//        frequency.addAll(map.values());
//
//        Heap<Long> heap = new Heap<>(true, frequency);
//        frequency = heap.heapsort(frequency);
//        long count = frequency.get(frequency.size() - k);
//
//        for (Map.Entry<Long, Long> e : map.entrySet()){
//            if (e.getValue() == count){
//                return e.getKey().intValue();
//            }
//        }
//        return nums.get(0);
//    }

    public void findK(ArrayList<Integer> nums, int k){
        Heap<Integer> getK = new Heap<Integer>(true, nums);
        getK.heapsort(nums);

        Collections.reverse(nums);
        for (int x = 0; x < nums.size(); x++){
            System.out.println(nums.get(k));
            break;
        }
    }

    public String findQ(ArrayList<String> array, int q){
        ArrayList<Integer> frequency = new ArrayList<Integer>();

        for (String i : array){
            frequency.add((int) i.chars().filter(b -> b == 'a').count());
        }

        Heap<Integer> heap = new Heap<Integer>(true, frequency);
        frequency = heap.heapsort(frequency);
        int count = frequency.get(frequency.size() - q);

        for (String j : array){
            if (j.chars().filter(b -> b == 'a').count() == count) return j;
        }
        return array.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> exampleString = new ArrayList<>(Arrays.asList("aaa", "abc", "aab", "AaAb", "zsw"));
        ArrayList<Integer> exampleInteger = new ArrayList<>(Arrays.asList(1,1,1,1,2,3,4,5,5,6,7,8,9,9,9));

        PriorityQueue test = new PriorityQueue();
        System.out.println(test.findQ(exampleString,2));

        PriorityQueue test2 = new PriorityQueue();
        test.findK(exampleInteger,2);

    }

}


