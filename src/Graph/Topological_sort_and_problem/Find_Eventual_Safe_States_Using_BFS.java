package Graph.Topological_sort_and_problem;

import java.util.*;

public class Find_Eventual_Safe_States_Using_BFS {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>> revGraph=new ArrayList<>();
        for (int i=0;i<n;i++) revGraph.add(new ArrayList<>());

        int []inDegree=new int[n];

        for (int i=0;i<n;i++){
            for (int node:graph[i]){
                revGraph.get(node).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();

        for (int i=0;i<n;i++){
            if(inDegree[i]==0) q.add(i);
        }
        ArrayList<Integer> result=new ArrayList<>();

        while (!q.isEmpty()){

            int node=q.poll();
              result.add(node);

          for (int adjNode:revGraph.get(node)){
              inDegree[adjNode]--;
              if (inDegree[adjNode]==0){
                  q.add(adjNode);
              }
          }
        }

         Collections.sort(result);
    return result;
    }
}
