package Graph.Topological_sort_and_problem;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_sort {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> connectedList=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<V;i++){
            connectedList.add(new ArrayList<>());
        }

        for (int i=0;i<edges.length;i++){
            connectedList.get(edges[i][0]).add(edges[i][1]);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int[] visi=new int[V];

        for (int i=0;i<V;i++){
            if(visi[i]==0){
                dfs(i,connectedList,st,visi);
            }
        }



        while (!st.empty()){
            ans.add(st.pop());
        }
        return ans;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> connectedList, Stack<Integer> st,int[] visi) {
        visi[node]=1;
        for (int i:connectedList.get(node)){
            if(visi[i]==0){
                dfs(i,connectedList,st,visi);
            }
        }
    st.push(node);
    }


}
