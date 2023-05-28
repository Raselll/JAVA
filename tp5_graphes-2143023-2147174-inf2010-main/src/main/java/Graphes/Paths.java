//package Graphes;
//import Interface.Graph;
//import java.security.InvalidParameterException;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//
//// -----------------------------------------------------------------------------//
//// Is it necessary to implement the reversePostOrderDfs function (Course 9 p.48)
//// -----------------------------------------------------------------------------//
//
//public class Paths{
//    boolean[] dfsMarked, bfsMarked;
//    int[] dfsParent, bfsParent;
//    int s;
//
//    public Paths(Graph G, int s) {
//        if (G == null || s < 0 || s >= G.V())
//            throw new InvalidParameterException();
//        this.s = s;
//
//        // process bfs
//        bfsMarked = new boolean[G.V()];
//        bfsParent = new int[G.V()];
//        bfs(G, s);
//
//        // process dfs
//        dfsMarked = new boolean[G.V()];
//        dfsParent = new int[G.V()];
//        dfs(G, s);
//    }
//
//    private void bfs(Graph G, int s) {
//        Queue<Integer> q = new LinkedList<Integer>();
//
//        // add source
//        q.add(s);
//        bfsMarked[s] = true;
//
//        while (!q.isEmpty()) {
//            // poll vertex and treat neighbors
//            int v = q.poll();
//            for (int w : G.adj(v)) {
//                if (!bfsMarked[w]) {
//                    bfsMarked[w] = true;
//                    bfsParent[w] = v;
//                    q.add(w);
//                }
//            }
//        }   // end while
//    }
//
//    public Stack<Integer> bfsPathTo(int v) {
//        if (!bfsMarked[v]) return null;
//        Stack<Integer> path = new Stack<Integer>();
//        for (int x = v; x != s; x = bfsParent[x])
//            path.push(x);
//        path.push(s);
//        return path;
//    }
//
//    private void dfs(Graph G, int v) {
//        dfsMarked[v] = true;
//        for (int w : G.adj(v))
//            if (!dfsMarked[w]) {
//                dfs(G, w);
//                dfsParent[w] = v;
//            }
//    }
//
//    public Stack<Integer> dfsPathTo(int v) {
//        if (!dfsMarked[v]) return null;
//        Stack<Integer> path = new Stack<Integer>();
//        for (int x = v; x != s; x = dfsParent[x])
//            path.push(x);
//        path.push(s);
//        return path;
//    }
//}