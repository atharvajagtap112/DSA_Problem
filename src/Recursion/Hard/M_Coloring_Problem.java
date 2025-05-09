package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class M_Coloring_Problem {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        List<Integer>[] G=new ArrayList[v];
         for (int i=0;i<edges.size();i++){
             int u=edges.get(i)[0];
             int w=edges.get(i)[1];
             G[u].add(w);
             G[w].add(u);
         }

       return solve(0,v,G,m, new int[v]);
    }

    private boolean solve(int node, int v, List<Integer>[] G, int m,int[]colors ) {
        if (node==v){
            return true;
        }
        for (int i=1;i<=m;i++){
            if (isSolve(node,G,colors,i)){
                colors[node]=i;
                if (solve(node+1,v,G,m,colors)) return true;
                colors[node]=0;
            }
        }
        return false;
    }

    private boolean isSolve(int node, List<Integer>[] G, int[] colors, int col) {
     for (int ele:G[node] ){
         if (colors[ele]==col){
             return false;
         }
     }
     return true;
    }
}
