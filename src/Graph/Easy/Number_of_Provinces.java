package Graph.Easy;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Provinces {
    public int findCircleNum(int[][] isConnected) {

        List<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);

                }
            }
        }

        int[] isVisited=new int[isConnected.length];
        int count =0;
        for (int i=0;i<isConnected.length;i++){
            if(isVisited[0]==0){
                count++;
                dfs(i,adjList,isVisited);
            }
        }
        return count;
    }

    private void dfs(int i, List<ArrayList<Integer>> adjList, int[] isVisited) {
           isVisited[i]=1;
           for (Integer node:adjList.get(i)){
               if(isVisited[node]==0){
                   dfs(node,adjList,isVisited);
               }
           }
    }
}