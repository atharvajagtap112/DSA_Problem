package Leetcode_DailyChanllenge;

import java.util.ArrayList;

public class Maximum_Number_of_K_Divisible_Components {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for (int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] component=new int[1];

        dfs(0,-1,n,adjList,k,component,values);
    return component[0];
    }

    int dfs(int currNode,int parentNode,int n,ArrayList<ArrayList<Integer>> adjList,int k,int[] component,int []values){


        int sum=0;
        for(int adjNode:adjList.get(currNode)){
            if(adjNode!=parentNode) {
                sum += dfs(adjNode, parentNode,n, adjList, k, component,values);
            }

            }

        sum%=k;

        sum+=values[currNode];
        sum%=k;
        if (sum==0) component[0]++;

        return sum;
    }
}
