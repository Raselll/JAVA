//package Graphes;
//import Interface.Graph;
//import java.util.LinkedList;
//import java.util.Queue;
//
//// -----------------------------------------------------------------------------//
//// For some reason, " getInDegree() " is not working properly (Course 8 p.39)
//// -----------------------------------------------------------------------------//
//
//public class TopologicalOrder {
//    int[] order;
//    boolean hasOrder;
//    Graph G;
//
//    TopologicalOrder(DirectedGraph G) {
//        order = new int[G.V()];
//        this.G = G;
//
//        findTopologicalOrder();
//    }
//
//    void findTopologicalOrder() {
//        int[] inDegree = ((DirectedGraph) G).getInDegree();
//        Queue<Integer> q = new LinkedList<Integer>();
//        for (int node = 0; node < G.V(); node++) {
//            if (inDegree[node] == 0)
//                q.add(node);
//            int counter = 0;
//            while (!q.isEmpty()) {
//                Integer v = q.poll();
//                order[v] = ++counter;
//                for (Integer w : G.adj(v))
//                    if (--inDegree[w] == 0)
//                        q.add(w);
//            }
//            hasOrder = (counter == G.V());
//        }
//    }
//}
