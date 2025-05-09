package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Minimum_Spanning_Tree {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        int [] visi =new int[V];
        int sum=0;
        pq.add(new int[]{0,0});

        while (!pq.isEmpty()){
            int [] edges=pq.poll();
            int node=edges[0];
            int wt=edges[1];

            if (visi[node]==1) continue;
            visi[node]=1;
            sum+=wt;

            for (int[] adjNodes:adj.get(node)){
                int adjNode=adjNodes[0];
                int adjWt=adjNodes[1];
                if (visi[adjNode]==0){
                    pq.add(new int[]{adjNode,adjWt});
                }
            }
        }
        return sum;
    }
}
