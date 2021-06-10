import java.util.*;
import java.io.*;
public class DepthFirstSearch {
    static void addEdge(ArrayList<ArrayList<Integer>> adjList,int u,int v){
        if(!adjList.get(u-1).contains(u))
            adjList.get(u-1).add(u);
        adjList.get(u-1).add(v);
        if(!adjList.get(v-1).contains(v))
            adjList.get(v-1).add(v);
        adjList.get(v-1).add(u);
    }


    static void DFS(ArrayList<ArrayList<Integer>> adj,int startNode){
        var visited = new boolean[adj.size()];
        var stack = new Stack<Integer>();
        visited[startNode-1] = true;
        stack.push(startNode);
        while(stack.size() > 0){
            startNode = stack.pop();
            System.out.print(startNode+" ");
            var itr = adj.get(startNode-1).iterator();
            while (itr.hasNext()) {
                var temp = itr.next();
                if(!visited[temp-1]){
                    visited[temp-1] = true;
                    stack.push(temp);
                }
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int graphSize = 5;
        while(graphSize > 0){
            adjList.add(new ArrayList<Integer>());
            graphSize-=1;
        }
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 5);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 2, 5);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 4, 5);
        System.out.println("\nDFS");
        DFS(adjList, 1);

    }
}
