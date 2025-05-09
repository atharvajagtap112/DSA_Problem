package Graph.Shortest_Path_Algorithm_And_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Shortest_path_in_Directed_Acyclic_Graph {

    class pair{
        int node;
        int weight;

        public pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<pair>> adjList=new ArrayList<>();
        for (int i=0;i<V;i++) adjList.add(new ArrayList<pair>());

        for (int []  edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adjList.get(u).add(new pair(v,w));
        }

        Stack<Integer> stack=new Stack<>();
        int [] visi=new int[V];
        for (int i=0;i<V;i++ ){
            if(visi[i]==0){
                dfs(i,stack,adjList,visi);
            }}

        int [] dist=new int[V];
        Arrays.fill(dist, (int) 1e9);

        dist[0]=0;
        while (!stack.isEmpty()){
            int node=stack.pop();
            int crntDist=dist[node];

            for (pair adjNode:adjList.get(node)) {
               if(adjNode.weight+crntDist<dist[adjNode.node]){
                   dist[node]=adjNode.weight+crntDist;
               }
            }}
        for(int i=0;i<V;i++){
            if(dist[i]==(int)1e9) dist[i]=-1;
        }
        return dist;
    }

    private void dfs(int i, Stack<Integer> stack, ArrayList<ArrayList<pair>> adjList,int []visi) {
        visi[i]=1;
        for (pair adjNode:adjList.get(i)){
            if(visi[adjNode.node]==0)
               dfs(adjNode.node,stack,adjList,visi);
        }
        stack.push(i);
    }
}
