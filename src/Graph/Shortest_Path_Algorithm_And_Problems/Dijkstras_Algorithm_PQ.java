package Graph.Shortest_Path_Algorithm_And_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras_Algorithm_PQ {
    class pair{
        int node;
        int dist;

        public pair(int dist, int node) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<pair>> adjList=new ArrayList<>();
        for (int i=0;i<V;i++) adjList.add(new ArrayList<pair>());

        for (int []  edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adjList.get(u).add(new pair(w,v));
        }

        int [] dist=new int[V];
        Arrays.fill(dist, (int) 1e9);
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->x.dist- y.dist);
        pq.add(new pair(0,src));
        dist[src]=0;

        while (!pq.isEmpty()){
            pair p=pq.poll();

            for (pair adjNode:adjList.get(p.node)){
                if(dist[adjNode.node]> adjNode.dist+ p.dist){
                    pq.add(new pair(adjNode.dist+p.dist,adjNode.node));
                }
            }

        }

        for(int i=0;i<V;i++){
            if(dist[i]==(int)1e9) dist[i]=-1;
        } 
        return dist;
    }
}
