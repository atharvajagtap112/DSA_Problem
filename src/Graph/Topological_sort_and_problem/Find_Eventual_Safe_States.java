package Graph.Topological_sort_and_problem;

import java.util.ArrayList;
import java.util.List;

public class Find_Eventual_Safe_States {

  public boolean dfs(int node,int[][]graph,int[] visi,int []path, int [] check){
       visi[node]=1;

       for (int adj:graph[node]){
           if(visi[adj]==0){
              if( dfs(adj,graph,visi,path,check)==true){ // if there is cycle then this is not safe node
                    check[adj]=0;
                    return true;
               } else if (path[adj]==1) {
                  return true;
              }
           }
       }

       //we have reach here that means there is no cycle and if there is no cycle then all node in this path are safe
       path[node]=0;
       check[node]=1;

       return false;
  }
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n=graph.length;

        int[] visi=new int[n];
        int []path =new int[n];
        int [] check=new int[n];

        for (int i=0;i<n;i++){
            if(visi[i]==0){
                dfs(i,graph,visi,path,check);
            }
        }

        ArrayList<Integer> result=new ArrayList<>();
        for (int node:check){
            if(node==1) result.add(node);
        }
        return result;
    }
}
