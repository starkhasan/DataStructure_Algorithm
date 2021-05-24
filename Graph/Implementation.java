import java.util.*;
public class Implementation {

    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        if(!adj.get(u-1).contains(u))
            adj.get(u-1).add(u);
        adj.get(u-1).add(v);
        if(!adj.get(v-1).contains(v))
            adj.get(v-1).add(v);
        adj.get(v-1).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adjList){
        
        for (var i = 0; i < adjList.size(); i++) {
            System.out.print("head ("+adjList.get(i).get(0)+")");
            for (int j = 0; j < adjList.get(i).size() - 1; j++) {
                System.out.print(" -> "+adjList.get(i).get(j+1));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       var totalNode = 5;
       var adjList = new ArrayList<ArrayList<Integer>>();
       for (var i = 0; i < totalNode; i++) {
           adjList.add(new ArrayList<Integer>());
       } 

       addEdge(adjList, 1, 2);
       addEdge(adjList, 1, 5);
       addEdge(adjList, 2, 3);
       addEdge(adjList, 2, 4);
       addEdge(adjList, 2, 5);
       addEdge(adjList, 3, 4);
       addEdge(adjList, 4, 5);
       System.out.println("\nGraph Implementation using Adjacency List ");
       printGraph(adjList);
    }    
}
