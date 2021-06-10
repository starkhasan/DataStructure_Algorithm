import java.util.*;
import java.io.*;
public class Demo {

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
            for (var j = 0; j < adjList.get(i).size() - 1; j++) {
                System.out.print(" -> "+adjList.get(i).get(j+1));
            }
            System.out.println();
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> adj, int s){
        var visited = new boolean[adj.size()];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s-1] = true;
        queue.add(s);
        while(queue.size() > 0){
            s = queue.poll();
            System.out.print(s+" ");
            var itr = adj.get(s-1).iterator();
            while(itr.hasNext()){
                int temp = itr.next();
                if(!visited[temp-1]){
                    visited[temp-1] = true;
                    queue.add(temp);
                }
            }
        }
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
        printGraph(adjList);
        System.out.println("\nBFS");
        bfs(adjList,1);
        System.out.println("\nDFS");
        DFS(adjList, 1);
    }    
}
