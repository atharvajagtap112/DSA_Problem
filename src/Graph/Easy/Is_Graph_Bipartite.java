package Graph.Easy;

public class Is_Graph_Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;

     int [] color=new int[n];
     for (int i=0;i<n;i++){
         color[i]=-1;
     }

     for (int i=0;i<n;i++){
         if(color[i]==-1){
            if( dfs(i,0,graph,color)==false){
                return false;
             }
         }

     }
     return true;
    }

  public boolean dfs(int node,int c,int[][] graph, int[] color){

         color[node]=c;

         for (int i:graph[node]){
             if(color[i]==-1){
                 if(dfs(i,1-c, graph,color)==false){
                 return false;
                 }
             }
             else if (c==color[i]) {
                 return false;
             }
         }
         return true;
    }
}
