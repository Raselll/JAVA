//package Graphes;
//import Interface.Graph;
//import java.security.InvalidParameterException;
//import java.util.HashSet;
//
//public class DirectedGraph implements Graph {
//
//    private HashSet<Integer>[] neighbors;       // listes d’adjacences
//    private int V, E;                           // cardinal de V et cardinal de E
//    private int[] inDegree;                     // membre additionnel
//
//    public DirectedGraph(int V){
//        initialize(V);
//    }
//
//    public void initialize(int V) {
//        // check parameters
//        if (V < 0) throw new InvalidParameterException();
//
//        // initialize members
//        E = 0;
//        this.V = V;
//        neighbors = new HashSet[V];
//
//        for (int v = 0; v < V; v++)
//            neighbors[v] = new HashSet<Integer>();
//    }
//
//    public int V(){return V;}
//
//    public int E(){return E;}
//
//    public void connect(int v1, int v2){
//        // check parameters
//        if(v1<0 || v1>=V) return;
//        if(v2<0 || v2>=V) return;
//        if( neighbors[v1].contains(v2) ) return;
//
//        // connect edge from v1 to v2
//        neighbors[v1].add(v2);
//        E++;
//        inDegree[v2]++;                         // le membre additionnel est incrémenté à chaque ajout d’arc
//    }
//
//    public DirectedGraph transposed(){
//        DirectedGraph T = new DirectedGraph(V);
//        for(int v=0; v<V; v++)
//            for(int w : neighbors[v])
//                T.connect(w, v);
//        return T;
//    }
//
//    public HashSet<Integer> adj(int v){
//        // check parameters
//        if(v<0 || v>=V) return null;
//        return neighbors[v];
//    }
//
//    public String toString(){
//        StringBuilder o = new StringBuilder();
//        String ln = System.getProperty("line.separator");
//        o.append(V + ln + E + ln);
//        for(int v=0; v<V; v++)
//            for(int w : neighbors[v])
//                o.append(v + "->" + w + ln);
//        return o.toString();
//    }
//}