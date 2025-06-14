package Graph.Shortest_Path_Algorithm_And_Problems;

import java.util.Arrays;

public class Bellman_Ford {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist=new int[V];
        Arrays.fill(dist, (int) 1e8);
        for (int i=0;i<V-1;i++){
            for (int [] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];

                if(dist[u]!=(int)1e8&&dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        for (int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            if(dist[u]!=(int)1e8&&dist[u]+w<dist[v]){
               return new int[]{-1};
            }
        }
        return dist;
    }
}
