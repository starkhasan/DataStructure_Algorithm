import java.util.*;

public class BreadthFirstSearch {
    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        if(!adj.get(u-1).contains(u))
            adj.get(u-1).add(u);
        adj.get(u-1).add(v);
        if(!adj.get(v-1).contains(v))
            adj.get(v-1).add(v);
        adj.get(v-1).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (var i = 0; i < adj.size(); i++) {
            System.out.print("head ("+adj.get(i).get(0)+")");
            for (var j = 0; j < adj.get(i).size() - 1; j++) {
                System.out.print(" -> "+adj.get(i).get(j+1));
            }
            System.out.println();
        }
    }


    static void BFS(ArrayList<ArrayList<Integer>> adj,int startNode){
        var visited = new boolean[adj.size()];
        var queue = new LinkedList<Integer>();

        visited[startNode-1] = true;
        queue.add(startNode);
        while(queue.size() > 0){
            startNode = queue.poll();
            System.out.print(startNode+" ");
            var itr = adj.get(startNode-1).iterator();
            while(itr.hasNext()){
                var temp = itr.next();
                if(!visited[temp-1]){
                    visited[temp-1] = true;
                    queue.add(temp);
                }
            }
        }
    }


    public static void main(String[] args) {
        var size = 5;
        var adjList = new ArrayList<ArrayList<Integer>>();
        for(var i=0;i<size;i++)
            adjList.add(new ArrayList<Integer>());
        addEdge(adjList,1,2);
        addEdge(adjList,1,5);
        addEdge(adjList,2,3);
        addEdge(adjList,2,4);
        addEdge(adjList,2,5);
        addEdge(adjList,3,4);
        addEdge(adjList,4,5);

        printGraph(adjList);
        BFS(adjList,1);

    }
}
