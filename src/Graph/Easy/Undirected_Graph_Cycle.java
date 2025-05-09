package Graph.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Undirected_Graph_Cycle {
    class pair{
        int value;
        int itsPparent;

        public pair(int value, int itsPparent) {
            this.value = value;
            this.itsPparent = itsPparent;
        }
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
         int n=adj.size();
        boolean[] visited=new boolean[n];

        for (int i=0;i<n;i++){
            if(visited[i]=false){
               if(detectCycle(i,visited,adj) ==true){
                   return true;
               }
            }
        }
       return false;
    }

    private boolean detectCycle(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<pair> q=new LinkedList<>();
        visited[i]=true;
        q.add(new pair(i,-1));

        while (!q.isEmpty()){
            pair pair=q.poll();
            int node=pair.value;
            int parent=pair.itsPparent;

            for (Integer ele:adj.get(node)){
                if(visited[ele]==false){
                    visited[ele]=true;
                    q.add(new pair(ele,node));
                }
               else if(parent!=ele) return true;
            }
        }
    return false;
    }



///////////////////////////////////////////////////////DFS 
    public boolean isCycle(int V, int[][] edges) {
        int[] visi=new int[V];

        ArrayList<ArrayList<Integer>> adj=new ArrayList();

        for(int i=0;i<V;i++) adj.add(new ArrayList<Integer>());

        for( int[] ele :edges ){
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);

        }

        for(int i=0;i<V;i++){
            if(visi[i]==0){
                if(dfs(i,-1,adj,visi)) return true;
            }
        }
        return false;

    }

    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visi){
        visi[node]=1;

        for(int i:adj.get(node)){
            if(visi[i]==0){
                if(dfs(i,node,adj,visi)) return true;
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
}
