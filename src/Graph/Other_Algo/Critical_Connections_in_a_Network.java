package Graph.Other_Algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Critical_Connections_in_a_Network {
    int time=1;
    public void dfs(int node,int parent,int [] low,int [] tin,List<List<Integer>> result,List<List<Integer>> adjList,int []visi){
        visi[node]=1;
        tin[node]=time;
        low[node]=time;
        time++;

        for (int adjNode:adjList.get(node)){
            if (visi[adjNode]==0){
                dfs(adjNode,node,low,tin,result,adjList,visi);
                if(tin[node]<low[adjNode]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(node);
                    temp.add(adjNode);
                    result.add(new ArrayList<>(temp));
                }
                low[node]=Math.min(low[node],low[adjNode]);
            }
            else {
                low[node]=Math.min(low[node],tin[adjNode]);
                return;
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
      List<List<Integer>>result=new ArrayList<>();
      int[] tin=new int[n];
      int[] low=new int[n];
      int [] visi=new int[n];
       List<List<Integer>> adjList=new ArrayList<>();
       for (int i=0;i<n;i++ ){
           adjList.add(new ArrayList<>());
       }

       for (List<Integer> edge:connections){
            int u=edge.get(0);
            int v=edge.get(1);
           adjList.get(edge.get(u)).add(v);
           adjList.get(edge.get(v)).add(u);
       }
        dfs(0,-1,low,tin,result,adjList,visi);
       return result;

    }
}
