package Graph.Topological_sort_and_problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Directed_Graph_Cycle_BFS_Topo_Sort {
    public boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> connectedNodes=new ArrayList<>();
        for (int i=0;i<V;i++) connectedNodes.add(new ArrayList<>());

        int[] inDegree=new int[V];
        for(int [] a:edges){
            inDegree[a[1]]++;
            connectedNodes.get(a[0]).add(a[1]);
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<V;i++){
            if(inDegree[i]==0) {
                q.add(i);}
        }
        int cnt=0;
        while (!q.isEmpty()){

            int node=q.poll();
        cnt++;
          for (int a:connectedNodes.get(node)){
              inDegree[a]--;
              if(inDegree[a]==0) q.add(a);
          }
        }



        return cnt!=V;
    }
}
