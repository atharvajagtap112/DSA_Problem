package Graph.Shortest_Path_Algorithm_And_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class shortest_path_undirected_graph_dijkstra_algorithm {

    class pair{
        int node;
        int dist;

        public pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));

        }

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] parent=new int[V];
        int []distArray=new int[V];
        Arrays.fill(distArray,(int)1e9);
        pq.add(new pair(src,0));
        distArray[src]=0;
        parent[src]=src;
        while (!pq.isEmpty()){
            pair p=pq.poll();

            for (pair adjEdges:adj.get(p.node)){
                if(distArray[adjEdges.node]>p.dist+adjEdges.dist){
                    parent[adjEdges.node]=p.node;
                    distArray[adjEdges.node]=p.dist+ adjEdges.dist;
                    pq.add(new pair(adjEdges.node, distArray[adjEdges.node]));
                }
            }
        }

        int node=V-1;
        ArrayList<Integer> ansList=new ArrayList<>();
        while (src!=distArray[node]){
            ansList.add(node);
            node=distArray[node];
        }
        ansList.add(src);
        Collections.reverse(ansList);

        return ansList.stream().mapToInt(Integer::intValue).toArray();

    }
}
