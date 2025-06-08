package Graph.Other_Algo;

import java.util.ArrayList;
import java.util.Stack;

public class Strongly_Connected {
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj, int[] visi, Stack<Integer> stack) {
        visi[node]=1;
        for (int adjNode:adj.get(node)){
            if(visi[adjNode]==0){
                dfs(adjNode,adj,visi,stack);
            }
        }

        stack.push(node);
    }

    private void dfs2(int node,ArrayList<ArrayList<Integer>> adj, int[] visi) {
        visi[node]=1;
        for (int adjNode:adj.get(node)){
            if(visi[adjNode]==0){
               dfs2(adjNode,adj,visi);
            }
        }


    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n=adj.size();
       int[] visi=new int[n];
       Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visi[i] == 0) {
                dfs(0,adj,visi,stack);
            }
        }
      

       //Reverse edge
        ArrayList<ArrayList<Integer>> adjTList=new ArrayList<>();
        for (int i=0;i<n;i++) adjTList.add(new ArrayList<>());

        for (int i=0;i<n;i++){
           visi[i]=0;
           for (Integer adjNode:adj.get(i)){
               adjTList.get(adjNode).add(i);
           }
       }

        int NoOfSCC=0;
       while (!stack.isEmpty()){
           int node=stack.pop();
           if(visi[node]==0){
               dfs2(node,adjTList,visi);
               NoOfSCC++;
           }

       }


return NoOfSCC;
    }


}
